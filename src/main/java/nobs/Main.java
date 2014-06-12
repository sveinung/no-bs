package nobs;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main
{
    public static void main(String[] args)
    {
        Main main = new Main(new Configuration(System.getProperties()));
        main.start();
    }

    private Configuration configuration;

    public Main(Configuration configuration)
    {
        this.configuration = configuration;
    }

    private void start()
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
            webApp = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        }
        WebAppContext webAppContext = new WebAppContext(webApp, "/");

        webAppContext.addEventListener(new ApplicationInitializer());

        return webAppContext;
    }
}
