package com.example.blog.repositories;

import com.example.blog.models.Categories;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Categories, Long> {

}
