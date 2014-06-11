package nobs;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Server srv = new Server(8080);

            srv.setStopAtShutdown(true);

            srv.setHandler(getWebAppContext());

            srv.start();
            srv.join();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static Handler getWebAppContext()
    {
        String webApp;
        if ("true".equals(System.getProperty("dev")))
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
