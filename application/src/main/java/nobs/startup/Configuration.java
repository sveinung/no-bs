package nobs.startup;

import java.util.Properties;

public class Configuration
{
    private static final String PORT = "port";
    private static final String DEV = "dev";

    private final Properties configurationProperties;

    public Configuration(Properties configurationProperties)
    {
        this.configurationProperties = configurationProperties;
    }

    public int getPort()
    {
        return Integer.parseInt(configurationProperties.getProperty(PORT));
    }

    public boolean isDev()
    {
        String devProperty = configurationProperties.getProperty(DEV);
        if (devProperty == null)
        {
            return false;
        } else
        {
            return Boolean.parseBoolean(devProperty);
        }
    }
}
