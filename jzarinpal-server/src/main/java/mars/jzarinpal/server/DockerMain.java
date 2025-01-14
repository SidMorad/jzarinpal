package mars.jzarinpal.server;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import mars.jzarinpal.domain.build.BuildProps;

public class DockerMain {
    /**
     * Grizzly HTTP server exposing JAX-RS resources defined in this application.
     *
     */
    public static HttpServer startServer() {
        return startServer(BuildProps.serviceLocalBaseUri);
    }

    public static HttpServer startServer(String baseUri) {
        // create a resource config that scan for JAX-RS resources and providers
        // in mars.jzarinpal.server.resources
        final ResourceConfig rc = new ResourceConfig().packages("mars.jzarinpal.server.resources");

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUri), rc);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started, Grizzly server %s", HttpServer.class.getPackage().getImplementationVersion()));

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Stopping server...");
                server.stop();
            }
        }, "shutdownHook"));

        try {
            server.start();
            Thread.currentThread().join();
        } catch (Exception e) {
            System.out.println("Error while starting server: " + e.getMessage());
        }
    }
}
