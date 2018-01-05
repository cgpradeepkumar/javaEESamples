package sample.rest.services;

import sample.rest.services.entities.Product;

/**
 * @author pkumar on 5/1/18
 * @project javaEESamples
 */
public interface ProductService {

    public Iterable<Product> listAllProducts();

    public Product getProductById(Integer id);

    public Product saveProduct(Product product);

    public void deleteProduct(Product product);

}
