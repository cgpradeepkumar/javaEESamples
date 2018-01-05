package sample.rest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pkumar on 2/1/18
 * @project javaEESamples
 */

@SpringBootApplication(scanBasePackages = "sample.rest")
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}
