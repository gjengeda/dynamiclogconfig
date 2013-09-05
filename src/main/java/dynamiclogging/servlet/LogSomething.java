package dynamiclogging.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogSomething extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogSomething.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Logging something");
        PrintWriter out = resp.getWriter();
        out.println("Logged a message");
        out.flush();
    }
    
}
