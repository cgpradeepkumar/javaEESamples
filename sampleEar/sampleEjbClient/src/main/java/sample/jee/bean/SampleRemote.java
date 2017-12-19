package sample.jee.bean;

import javax.ejb.Remote;

@Remote
public interface SampleRemote {

    public static String JNDI_NAME = "sample/SampleBean";

    public String greeting(String name);

    public String serverInfo();
}
