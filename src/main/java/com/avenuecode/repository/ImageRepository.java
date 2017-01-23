package com.avenuecode.repository;

import com.avenuecode.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "image", path = "image")
public interface ImageRepository extends CrudRepository<Image, Long> {

}