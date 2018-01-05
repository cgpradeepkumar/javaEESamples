package sample.jee.bean.util;

import com.ibm.websphere.naming.PROPS;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.util.Hashtable;

/**
 * Created by pkumar on 14/3/17.
 */
public class ServiceResolver {

    private static ServiceResolver instance;
    private Context initialContext;

    private ServiceResolver() {
    }

    public static synchronized ServiceResolver getInstance() {
        if(instance == null) {
            instance = new ServiceResolver();
        }

        return instance;
    }

    private Context getInitialContext() throws NamingException {
        if (initialContext == null) {
            Hashtable environment = new Hashtable();
            environment.put("org.omg.CORBA.ORBClass", "com.ibm.CORBA.iiop.ORB");
            environment.put("org.omg.CORBA.ORBSingletonClass", "com.ibm.rmi.corba.ORBSingleton");
            environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");
            environment.put(Context.PROVIDER_URL, "corbaloc:iiop:localhost:9100");
//            environment.put(PROPS.NAME_SPACE_ROOT, PROPS.NAME_SPACE_ROOT_BOOTSTRAP_SERVER);
            environment.put(PROPS.NAME_SPACE_ROOT, PROPS.NAME_SPACE_ROOT_DEFAULT);
            initialContext = new InitialContext(environment);
        }

        return initialContext;
    }

    public <T> T lookup(String jndiName, Class<T> clazz) throws NamingException {

        Object object = getInitialContext().lookup(jndiName);
        T result = null;
        try {
            result = (T) PortableRemoteObject.narrow(object, clazz);

        } catch (Throwable t) {
            t.printStackTrace();
        }

        if (result == null) {
            throw new NamingException("unable to narrow object!");
        }
        return result;
    }

    public Object lookup(String jndiName) throws NamingException {
        //String context = "localhostNode01Cell/nodes/localhostNode01/servers/server1/";

        Object object = getInitialContext().lookup(jndiName);
        return object;
    }
}
