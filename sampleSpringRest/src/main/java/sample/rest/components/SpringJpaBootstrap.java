package sample.rest.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sample.rest.services.entities.Product;
import sample.rest.services.repositories.ProductRepository;

import java.math.BigDecimal;

/**
 * @author pkumar on 5/1/18
 * @project javaEESamples
 */

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
    }

    private void loadProducts() {

        Product product1 = new Product();
        product1.setProductId("11-326159487");
        product1.setDescription("product 1");
        product1.setImageUrl("http://sample.rest/image1.jpg");
        product1.setPrice(new BigDecimal(18.56));

        productRepository.save(product1);


        Product product2 = new Product();
        product2.setProductId("11-784951623");
        product2.setDescription("product 2");
        product2.setImageUrl("http://sample.rest/image2.jpg");
        product2.setPrice(new BigDecimal(154.99));

        productRepository.save(product2);
    }
}
