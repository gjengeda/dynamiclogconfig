package dynamiclogging.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class MyServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar("target/dynamiclogconfig-0.1");
        server.setHandler(webapp);
        server.start();
        server.join();
    }
}
