package com.exercise.add_product_to_cart.controller;

import com.exercise.add_product_to_cart.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("")
    public String showList(@SessionAttribute("cart") CartDto cart, Model model){
        model.addAttribute("cart", cart);
        return "/cart/list";
    }

    @GetMapping("/pay")
    public String pay(@SessionAttribute("cart") CartDto cartDto, RedirectAttributes redirectAttributes){
        cartDto.pay();
        redirectAttributes.addFlashAttribute("message", "Pay success");
        return "redirect:/shop";
    }
}
