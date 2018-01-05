package sample.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.rest.services.entities.Product;
import sample.rest.services.repositories.ProductRepository;

/**
 * @author pkumar on 5/1/18
 * @project javaEESamples
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return null;
    }

    @Override
    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {

        productRepository.delete(product);
    }
}
