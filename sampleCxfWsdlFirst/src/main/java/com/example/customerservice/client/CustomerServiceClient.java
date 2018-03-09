package com.example.customerservice.client;

import com.example.customerservice.Customer;
import com.example.customerservice.CustomerService;
import com.example.customerservice.CustomerServiceService;
import com.example.customerservice.NoSuchCustomerException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author pkumar on 9/3/18
 * @project javaEESamples
 */
public class CustomerServiceClient {

    public static void main(String[] args) {
        CustomerServiceService serviceService;

        try {
            URL wsdlUrl = new URL("http://localhost:9090/CustomerServicePort?wsdl");
            serviceService = new CustomerServiceService(wsdlUrl);


            CustomerService customerService = serviceService.getCustomerServicePort();
            java.util.List<Customer> customers = customerService.getCustomersByName("Pradeep");

            customers.forEach(customer -> System.out.println(customer));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NoSuchCustomerException e) {
            e.printStackTrace();
        }
    }
}
