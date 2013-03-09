package nobs;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

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

    private static Handler getWebAppContext() {
        String webApp;
        if ("true".equals(System.getProperty("dev"))) {
            webApp = "src/main/webapp";
        } else {
            webApp = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        }
        WebAppContext webAppContext = new WebAppContext(webApp, "/");

        webAppContext.addServlet(getResourceServletHolder(), "/rest/*");

        return webAppContext;
    }

    private static ServletHolder getResourceServletHolder() {
        ServletHolder resourceServletHolder = new ServletHolder(ServletContainer.class);

        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("javax.ws.rs.Application", MyApplication.class.getCanonicalName());
        initParameters.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

        resourceServletHolder.setInitParameters(initParameters);

        return resourceServletHolder;
    }
}
