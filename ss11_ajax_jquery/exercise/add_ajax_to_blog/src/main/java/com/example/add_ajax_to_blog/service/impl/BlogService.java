package com.example.add_ajax_to_blog.service.impl;

import com.example.add_ajax_to_blog.model.Blog;
import com.example.add_ajax_to_blog.model.Category;
import com.example.add_ajax_to_blog.repository.IBlogRepository;
import com.example.add_ajax_to_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByAuthorContainingOrContentContainingOrTitleContaining(String name) {
        return blogRepository.findByAuthorContainingOrContentContainingOrTitleContaining(name, name, name);
    }

    @Override
    public Page<Blog> searchAuthorOrContentOrTitle(String name, Pageable pageable) {
        return blogRepository.searchAuthorOrContentOrTitle(name, name, name, pageable);
    }

    @Override
    public void updateFlag(int id) {
        blogRepository.updateFlag(id);
    }

    @Override
    public Iterable<Blog> findAllByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }
}
