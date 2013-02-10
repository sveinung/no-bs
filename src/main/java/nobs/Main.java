package nobs;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class Main {
    public static void main(String[] args) {
        try {
            Server srv = new Server();

            srv.setStopAtShutdown(true);
            srv.setGracefulShutdown(5000);
            srv.setThreadPool(getQueuedThreadPool());
            srv.setConnectors(getConnectors());

            HandlerList handlers = new HandlerList();
            handlers.addHandler(getStaticPages());
            handlers.addHandler(getJerseyResourceHandler(srv));

            srv.setHandler(handlers);

            srv.start();
            srv.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private static ServletContextHandler getJerseyResourceHandler(Server srv) {
        ServletHolder sh = new ServletHolder(ServletContainer.class);
        sh.setInitParameter("com.sun.jersey.config.property.packages", "nobs.products");

        ServletContextHandler context = new ServletContextHandler(srv, "/", ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(sh, "/*");

        return context;
    }

    private static ResourceHandler getStaticPages() {
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase("src/main/webapp");
        return resourceHandler;
    }
}
