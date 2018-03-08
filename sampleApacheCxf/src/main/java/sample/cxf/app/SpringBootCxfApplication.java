package sample.cxf.app;


import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import sample.cxf.services.StudentService;
import sample.cxf.services.StudentServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * @author pkumar on 1/3/18
 * @project javaEESamples
 */

@SpringBootApplication
public class SpringBootCxfApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCxfApplication.class);
    }

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/sampleApacheCxf/services/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return  new SpringBus();
    }

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), studentService());
        endpoint.publish();
        endpoint.setWsdlLocation("student-service1.0.wsdl");
        return endpoint;
    }
}
