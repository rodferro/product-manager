package com.avenuecode.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "withoutRelationships", types = {Product.class})
public interface WithoutRelationships {

    String getName();

    String getDescription();
}
