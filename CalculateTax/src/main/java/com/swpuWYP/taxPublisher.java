package com.swpuWYP;

import javax.xml.ws.Endpoint;

public class taxPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/PersonalIncomeTaxService", new taxServiceImpl());
        System.out.println("Service is published!");
    }
}
