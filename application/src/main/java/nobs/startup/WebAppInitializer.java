package nobs.startup;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public abstract class WebAppInitializer implements ServletContextListener
{
    abstract void initialize(ServletContext servletContext);

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        ServletContext servletContext = sce.getServletContext();

        initialize(servletContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
    }
}
