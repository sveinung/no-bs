package nobs;

import com.sun.jersey.spi.container.servlet.ServletContainer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import java.util.HashMap;

public class ApplicationInitializer implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        ServletContext servletContext = sce.getServletContext();

        ServletRegistration.Dynamic jersey = servletContext.addServlet("jersey", new ServletContainer());
        jersey.addMapping("/rest/*");

        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("javax.ws.rs.Application", MyApplication.class.getCanonicalName());
        initParameters.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

        jersey.setInitParameters(initParameters);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
    }
}
