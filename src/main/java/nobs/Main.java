package nobs;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try {
            Server srv = new Server();

            srv.setStopAtShutdown(true);
            srv.setGracefulShutdown(5000);
            srv.setThreadPool(getQueuedThreadPool());
            srv.setConnectors(getConnectors());
            srv.setHandler(getWebAppContext());

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

    private static WebAppContext getWebAppContext() throws Exception {
        Resource webAppContextConfig = Resource.newSystemResource("webappcontext.xml");

        XmlConfiguration xmlConfiguration = new XmlConfiguration(webAppContextConfig.getInputStream());
        xmlConfiguration.configure();

        WebAppContext webAppContext = (WebAppContext) xmlConfiguration.getIdMap().get("webAppContext");

        if (webAppContext == null) {
            throw new IllegalStateException("something is wrong in the configuration");
        }

        return webAppContext;
    }
}
