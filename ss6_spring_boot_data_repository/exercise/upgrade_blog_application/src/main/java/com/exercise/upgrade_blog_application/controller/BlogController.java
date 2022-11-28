package com.exercise.upgrade_blog_application.controller;


import com.exercise.upgrade_blog_application.model.Blog;
import com.exercise.upgrade_blog_application.model.Category;
import com.exercise.upgrade_blog_application.service.IBlogService;
import com.exercise.upgrade_blog_application.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private IBlogService blogService;
    private ICategoryService categoryService;

    public BlogController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.findAllCategoryFlag();
    }

    @RequestMapping("")
    public String showListBlog(@RequestParam(defaultValue = "") String search, @PageableDefault(page = 0, size = 5, sort = {"date_start"}) Pageable pageable, Model model) {
        Page<Blog> blogList = blogService.searchAuthorOrContentOrTitle(search, pageable);
        model.addAttribute("blogList", blogList);
        model.addAttribute("search", search);
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "/blog/list";
    }

        @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create success");
        return "redirect:/blog";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") int id, RedirectAttributes redirectAttributes){
        blogService.updateFlag(id);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/blog";
    }


}
