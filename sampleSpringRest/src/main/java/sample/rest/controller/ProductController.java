package sample.rest.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sample.rest.services.ProductService;
import sample.rest.services.entities.Product;

/**
 * @author pkumar on 2/1/18
 * @project javaEESamples
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "View the list available product")
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Product> list(Model model) {
        return productService.listAllProducts();
    }

    @ApiOperation(value = "Update a product")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Product storedProduct = productService.getProductById(id);
        storedProduct.setDescription(product.getDescription());
        storedProduct.setImageUrl(product.getImageUrl());
        storedProduct.setPrice(product.getPrice());
        productService.saveProduct(storedProduct);
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }
}
