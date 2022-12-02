package com.exercise.add_product_to_cart.controller;

import com.exercise.add_product_to_cart.dto.CartDto;
import com.exercise.add_product_to_cart.dto.ProductDto;
import com.exercise.add_product_to_cart.model.Product;
import com.exercise.add_product_to_cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping("/shop")
    public String showShop(Model model, @CookieValue(value = "id", defaultValue = "-1") int id) {
        Iterable<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        if (id != -1) {
            model.addAttribute("historyProduct", productService.findById(id).get());
        }
        return "/product/list";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") int id, @SessionAttribute("cart") CartDto cartDto, @RequestParam("action") String action, RedirectAttributes redirectAttributes) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error";
        }
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(), productDto);
        if (action.equals("show")) {
            cartDto.addProduct(productDto);
            return "redirect:/cart";
        } else {
            cartDto.addProduct(productDto);
            redirectAttributes.addFlashAttribute("message", "Add success");
            return "redirect:/shop";
        }
    }

    @GetMapping("/sub/{id}")
    public String subToCart(@PathVariable("id") int id, @SessionAttribute("cart") CartDto cartDto, @RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error";
        }
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(), productDto);
        if (action.equals("show")) {
            cartDto.subProduct(productDto);
            return "redirect:/cart";
        } else {
            cartDto.subProduct(productDto);
            return "redirect:/shop";
        }
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") int id, Model model, HttpServletResponse response) {
        Cookie cookie = new Cookie("id", String.valueOf(id));
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);

        Optional<Product> product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(), productDto);
        model.addAttribute("product", productDto);
        return "/product/detail";
    }




}
