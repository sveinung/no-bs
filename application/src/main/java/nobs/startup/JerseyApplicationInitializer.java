package nobs.startup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.HashMap;

public class JerseyApplicationInitializer extends WebAppInitializer
{
    @Override
    public void initialize(ServletContext servletContext)
    {
        servletContext.setInitParameter("contextConfigLocation", "classpath:applicationContext.xml");

        ServletRegistration.Dynamic jersey = servletContext.addServlet(
                "jersey",
                new ServletContainer(createJerseyResourceConfig()));
        jersey.addMapping("/rest/*");

        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("com.sun.jersey.api.json.POJOMappingFeature", "true");

        jersey.setInitParameters(initParameters);
    }

    private ResourceConfig createJerseyResourceConfig()
    {
        ResourceConfig resourceConfig = new ResourceConfig();

        resourceConfig
                .packages("nobs.library")
                ;

        return resourceConfig;
    }
}
