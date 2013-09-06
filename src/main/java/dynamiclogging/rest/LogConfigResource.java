package dynamiclogging.rest;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.slf4j.LoggerFactory.getILoggerFactory;

@Path("/logconfig")
public class LogConfigResource {

    @GET
    @Path("/list")
    @Produces(APPLICATION_JSON)
    public List<LoggerJSONObject> list() {
        return transformToJSON(((LoggerContext) getILoggerFactory()).getLoggerList());
    }

    private List<LoggerJSONObject> transformToJSON(List<Logger> loggers) {
        List<LoggerJSONObject> loggerJsonObjects = new ArrayList<LoggerJSONObject>();
        for (Logger logger : loggers) {
            Level level = logger.getLevel();
            loggerJsonObjects.add(new LoggerJSONObject(logger.getName(), level != null ? level.toString() : null));
        }
        return loggerJsonObjects;
    }

    @PUT
    @Path("/setLevel")
    public void setLevel(LoggerJSONObject loggerJSONObject) {
        Logger logger = (Logger) LoggerFactory.getLogger(loggerJSONObject.name);
        String level = loggerJSONObject.level;
        logger.setLevel(isBlank(level) ? null : Level.toLevel(level));
    }

    private boolean isBlank(String level) {
        return level == null || level == "";
    }

}
