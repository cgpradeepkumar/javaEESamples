package sample.rest.services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sample.rest.services.entities.Product;

/**
 * @author pkumar on 5/1/18
 * @project javaEESamples
 */

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
