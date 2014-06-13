package nobs;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyAdapter implements ContainerAdapter
{
    private Configuration configuration;
    private WebAppInitializer webAppInitializer;

    public JettyAdapter(
            Configuration configuration,
            WebAppInitializer webAppInitializer)
    {
        this.configuration = configuration;
        this.webAppInitializer = webAppInitializer;
    }

    @Override
    public void start()
    {
        try
        {
            Server srv = new Server(configuration.getPort());

            srv.setStopAtShutdown(true);

            srv.setHandler(getWebAppContext());

            srv.start();
            srv.join();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private Handler getWebAppContext()
    {
        String webApp;
        if (configuration.isDev())
        {
            webApp = "src/main/webapp";
        } else
        {
            webApp = Application.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        }
        WebAppContext webAppContext = new WebAppContext(webApp, "/");

        webAppContext.addEventListener(webAppInitializer);

        return webAppContext;
    }
}
