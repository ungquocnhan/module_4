package com.exercise.restful_blog.controller;

import com.exercise.restful_blog.dto.BlogDto;
import com.exercise.restful_blog.model.Blog;
import com.exercise.restful_blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> getListBlog(@RequestParam(defaultValue = "") String search, @PageableDefault(page = 0, size = 3) Pageable pageable) {
        Page<Blog> blogPage = blogService.searchAuthorOrContentOrTitle(search, pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> detailBog(@PathVariable("id") int id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
//        blog.setCategory(blogService.findById(blog.getCategory().getId()));
//        Blog blog = new Blog();
//        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        Blog blog1 = blogService.findById(blog.getId()).get();
        return new ResponseEntity<>(blog1,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable("id") int id, @RequestBody Blog blog){
        Optional<Blog> blogOptional = blogService.findById(id);
        if(!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Blog> detete(@PathVariable("id") int id){
        Optional<Blog> blog = blogService.findById(id);
        if(!blog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.updateFlag(blog.get().getId());
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);

    }
}
