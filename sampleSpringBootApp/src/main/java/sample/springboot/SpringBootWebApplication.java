package sample.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by pkumar on 20/6/17.
 */

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootWebApplication.class);
    }

    public static void main(String arg[]) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, arg);
    }

}
