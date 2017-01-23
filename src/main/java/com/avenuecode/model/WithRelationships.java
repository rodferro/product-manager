package com.avenuecode.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "withRelationships", types = {Product.class})
public interface WithRelationships {

    String getDescription();

    String getName();

    Product getParentProduct();

    List<Product> getChildProducts();

    List<Image> getImages();
}
