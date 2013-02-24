package nobs;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
    public static void main(String[] args) {
        try {
            Server srv = new Server();

            srv.setStopAtShutdown(true);
            srv.setGracefulShutdown(5000);
            srv.setThreadPool(getQueuedThreadPool());
            srv.setConnectors(getConnectors());

            HandlerList handlers = new HandlerList();

            handlers.addHandler(getWebAppContext());

            srv.setHandler(handlers);

            srv.start();
            srv.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static WebAppContext getWebAppContext() {
        WebAppContext webAppContext = new WebAppContext("src/main/webapp", "/");
        webAppContext.setContextPath("/");
        return webAppContext;
    }

    private static QueuedThreadPool getQueuedThreadPool() {
        QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setMaxThreads(100);

        return threadPool;
    }

    private static Connector[] getConnectors() {
        Connector connector = new SelectChannelConnector();
        connector.setPort(8080);
        connector.setMaxIdleTime(30000);

        return new Connector[]{connector};
    }
}
