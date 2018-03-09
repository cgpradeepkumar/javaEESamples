package com.example.customerservice;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.2
 * 2018-03-08T19:42:13.195+05:30
 * Generated source version: 3.2.2
 *
 */
@WebService(targetNamespace = "http://customerservice.example.com/", name = "CustomerService")
@XmlSeeAlso({ObjectFactory.class})
public interface CustomerService {

    @WebMethod
    @Oneway
    @RequestWrapper(localName = "updateCustomer", targetNamespace = "http://customerservice.example.com/", className = "com.example.customerservice.UpdateCustomer")
    public void updateCustomer(
        @WebParam(name = "customer", targetNamespace = "")
        com.example.customerservice.Customer customer
    );

    @WebMethod
    @RequestWrapper(localName = "getCustomersByName", targetNamespace = "http://customerservice.example.com/", className = "com.example.customerservice.GetCustomersByName")
    @ResponseWrapper(localName = "getCustomersByNameResponse", targetNamespace = "http://customerservice.example.com/", className = "com.example.customerservice.GetCustomersByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.example.customerservice.Customer> getCustomersByName(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    ) throws NoSuchCustomerException;
}
