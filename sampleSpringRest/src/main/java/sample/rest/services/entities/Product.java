package sample.rest.services.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author pkumar on 5/1/18
 * @project javaEESamples
 */

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated product id")
    private Integer id;

    @Version
    @ApiModelProperty(notes = "The auto generated version of product")
    private Integer version;

    @ApiModelProperty(notes = "The application generated product id")
    private String productId;

    @ApiModelProperty(notes = "The description of product")
    private String description;

    @ApiModelProperty(notes = "The image url of product")
    private String imageUrl;

    @ApiModelProperty(notes = "The price of the product")
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
