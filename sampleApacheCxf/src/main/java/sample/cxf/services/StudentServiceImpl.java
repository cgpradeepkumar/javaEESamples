package sample.cxf.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author pkumar on 1/3/18
 * @project javaEESamples
 */

@WebService(endpointInterface = "sample.cxf.services.StudentService")
public class StudentServiceImpl implements StudentService {

    @Override
    @WebMethod
    public String name() {
        return "Testing.......";
    }
}
