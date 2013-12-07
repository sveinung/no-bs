package nobs;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.HashMap;

public class NoBsWebAppContext extends WebAppContext {

    private static String webApp;

    static {
        if ("true".equals(System.getProperty("dev"))) {
            webApp = "src/main/webapp";
        } else {
            webApp = NoBsWebAppContext.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        }
    }

    public NoBsWebAppContext() {
        super(webApp, "/");

        this.addServlet(getResourceServletHolder(), "/rest/*");
    }

    private ServletHolder getResourceServletHolder() {
        ServletHolder resourceServletHolder = new ServletHolder(ServletContainer.class);

        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("javax.ws.rs.Application", MyApplication.class.getCanonicalName());
        initParameters.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

        resourceServletHolder.setInitParameters(initParameters);

        return resourceServletHolder;
    }
}
