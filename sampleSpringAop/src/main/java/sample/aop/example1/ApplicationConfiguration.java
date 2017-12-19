package sample.aop.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by pkumar on 28/9/17.
 */

@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfiguration {

    @Bean
    public AddressBean addressBean() {
        return new AddressBean();
    }

    @Bean
    public SampleAspect sampleAspect() {
        return new SampleAspect();
    }
}
