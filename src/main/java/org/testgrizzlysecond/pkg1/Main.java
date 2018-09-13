package org.testgrizzlysecond.pkg1;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        org.glassfish.jersey.server.ResourceConfig rc = new ResourceConfig();
        rc.registerClasses(DummyController.class);
        //rc.register(JacksonFeature.class);
//        rc.property("jersey.config.server.tracing.type", "ALL");
//        rc.property("jersey.config.server.tracing.threshold", "VERBOSE");
        URI uri = URI.create("http://localhost");
        HttpServer webServer = GrizzlyHttpServerFactory.createHttpServer(uri, rc, false);
        System.out.println("Server Created");
        try {
            webServer.start();
            System.out.println("Server Started");
        } catch (IOException e) {
        }
    }
}