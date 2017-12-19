package sample.aop.example1;

/**
 * Created by pkumar on 28/9/17.
 */

import org.apache.log4j.Logger;

public class AddressBean {

    private static Logger logger = Logger.getLogger(AddressBean.class);

    public void createAddress() {
        logger.info("Creating new Address....");
    }

    public String getAddress() {
        return "Xyz";
    }
}
