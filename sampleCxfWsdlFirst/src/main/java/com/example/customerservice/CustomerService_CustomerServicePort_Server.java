
package com.example.customerservice;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 3.2.2
 * 2018-03-08T19:42:13.200+05:30
 * Generated source version: 3.2.2
 *
 */

public class CustomerService_CustomerServicePort_Server{

    protected CustomerService_CustomerServicePort_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new CustomerServicePortImpl();
        String address = "http://localhost:9090/CustomerServicePort";
        Endpoint.publish(address, implementor);
    }

    public static void main(String args[]) throws java.lang.Exception {
        new CustomerService_CustomerServicePort_Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
