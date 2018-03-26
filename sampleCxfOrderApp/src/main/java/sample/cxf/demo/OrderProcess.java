package sample.cxf.demo;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author pkumar on 23/3/18
 * @project javaEESamples
 */

@WebService
public interface OrderProcess {

    @WebMethod
    String processOrder(Order order);
}
