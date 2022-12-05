package com.exercise.restful_blog.controller;

import com.exercise.restful_blog.model.Blog;
import com.exercise.restful_blog.model.Category;
import com.exercise.restful_blog.service.IBlogService;
import com.exercise.restful_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<Iterable<Category>> getList(@PageableDefault(page = 0, size = 3) Pageable pageable){
        Page<Category> categoryList = categoryService.findAllCategoryFlag(pageable);
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Iterable<Blog>> viewCategory(@PathVariable("id") int id){
        Optional<Category> category = categoryService.findById(id);
        if(!category.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<Blog> blogs = blogService.findAllByCategory(category.get());
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
