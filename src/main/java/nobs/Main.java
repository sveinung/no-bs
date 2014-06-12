package nobs;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main
{
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration(System.getProperties());

        try
        {
            Server srv = new Server(configuration.getPort());

            srv.setStopAtShutdown(true);

            srv.setHandler(getWebAppContext(configuration));

            srv.start();
            srv.join();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static Handler getWebAppContext(Configuration configuration)
    {
        String webApp;
        if (configuration.isDev())
        {
            webApp = "src/main/webapp";
        } else
        {
            webApp = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        }
        WebAppContext webAppContext = new WebAppContext(webApp, "/");

        webAppContext.addEventListener(new ApplicationInitializer());

        return webAppContext;
    }
}
