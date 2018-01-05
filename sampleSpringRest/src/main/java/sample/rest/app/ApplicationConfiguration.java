package sample.rest.app;

import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author pkumar on 5/1/18
 * @project javaEESamples
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"sample.rest.services.entities"})
@EnableJpaRepositories(basePackages = {"sample.rest.services.repositories"})
@EnableTransactionManagement
public class ApplicationConfiguration {

    @Bean
    ServletRegistrationBean h2serServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;
    }
}
