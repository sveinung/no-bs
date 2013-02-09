package nobs;

import org.eclipse.jetty.server.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(8080);

        server.setStopAtShutdown(true);

        try {
            server.start();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
