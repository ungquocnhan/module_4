package com.exercise.upgrade_blog_application.controller;

import com.exercise.upgrade_blog_application.model.Blog;
import com.exercise.upgrade_blog_application.model.Category;
import com.exercise.upgrade_blog_application.service.IBlogService;
import com.exercise.upgrade_blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    private IBlogService blogService;

    @RequestMapping("")
    public String showListCategory(Model model) {
        List<Category> categoryList = categoryService.findAllCategoryFlag();
        model.addAttribute("categoryList", categoryList);
        Category category = new Category();
        model.addAttribute("category", category);
        return "/category/list";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Add success");
        return "redirect:/category";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam("deleteId") int id, RedirectAttributes redirectAttributes) {
        categoryService.updateFlag(id);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/category";
    }


    @PostMapping("/update")
    public String updateCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/category";
    }

    @GetMapping("/view/{id}")
    public String viewCategory(@PathVariable("id") int id, Model model) {
        Optional<Category> category = categoryService.findById(id);
        if (!category.isPresent()) {
            return "error-404";
        }

        Iterable<Blog> blogs = blogService.findAllByCategory(category.get());
        model.addAttribute("category", category.get());
        model.addAttribute("blogs", blogs);
        return "/category/view";
    }
}
