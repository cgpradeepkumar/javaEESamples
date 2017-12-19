package sample.jee.bean.test;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import sample.jee.bean.SampleRemote;
import sample.jee.bean.util.ServiceResolver;

import javax.naming.NamingException;

/**
 * Created by pkumar on 14/3/17.
 */
public class SampleBeanTest extends TestCase {

    @Test
    public void test() {

        SampleRemote sampleRemote = null;
        try {
            sampleRemote = ServiceResolver.getInstance().lookup(SampleRemote.JNDI_NAME, SampleRemote.class);
            System.out.print(sampleRemote.greeting("Pradeep"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(sampleRemote);
    }
}
