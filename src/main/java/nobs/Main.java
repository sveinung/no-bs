package nobs;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class Main {
    public static void main(String[] args) {
        try {
            Server srv = new Server();
            srv.setStopAtShutdown(true);

            srv.setGracefulShutdown(5000);

            QueuedThreadPool threadPool = new QueuedThreadPool();
            threadPool.setMaxThreads(100);
            srv.setThreadPool(threadPool);

            Connector connector = new SelectChannelConnector();
            connector.setPort(8080);
            connector.setMaxIdleTime(30000);
            srv.setConnectors(new Connector[]{connector});

            HandlerList handlers = new HandlerList();
            handlers.addHandler(getStaticPages());
            srv.setHandler(handlers);

            srv.start();
            srv.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ResourceHandler getStaticPages() {
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{ "index.html" });
        resourceHandler.setResourceBase("src/main/webapp");
        return resourceHandler;
    }
}
