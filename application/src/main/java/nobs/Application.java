package nobs;

import nobs.startup.Configuration;
import nobs.startup.ContainerAdapter;
import nobs.startup.JerseyApplicationInitializer;
import nobs.startup.JettyAdapter;

public class Application
{
    public static void main(String[] args)
    {
        Application application = new Application(
                new JettyAdapter(
                        new Configuration(System.getProperties()),
                        new JerseyApplicationInitializer()));

        application.start();
    }

    private ContainerAdapter containerAdapter;

    public Application(ContainerAdapter containerAdapter)
    {
        this.containerAdapter = containerAdapter;
    }

    private void start()
    {
        containerAdapter.start();
    }
}
