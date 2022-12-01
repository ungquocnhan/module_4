package com.exercise.rent_book.controller;

import com.exercise.rent_book.model.Book;
import com.exercise.rent_book.model.Order;
import com.exercise.rent_book.service.IBookService;
import com.exercise.rent_book.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping("")
    public String showListBook(@RequestParam(defaultValue = "") String search, @PageableDefault(page = 0, size = 5) Pageable pageable, Model model) {
        Page<Book> books = bookService.findAllByNameContaining(search, pageable);
        model.addAttribute("books", books);
        return "/book/list";
    }

    @GetMapping("/rent/{id}")
    public String showRent(@PathVariable("id") int id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "/book/rent";
        } else {
            return "/error";
        }
    }


    @PostMapping("/rent")
    public String rent(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) throws Exception {
        if (book.getAmount() == 0) {
            throw new Exception();
        }
        int idRent = orderService.getIdRent(book);
        bookService.rentBook(book.getId());
        redirectAttributes.addFlashAttribute("message", "Rent book success - ID Rent book :" + idRent);
        return "redirect:/book";
    }


    @GetMapping("/pay")
    public String showPayBook(Model model) {
        Order order = new Order();
        model.addAttribute("payBook", order);
        List<Order> orderList = orderService.findAllOrder();
        model.addAttribute("orderList", orderList);
        return "/book/pay";
    }

    @PostMapping("/pay")
    public String payBook(@ModelAttribute("payBook") Order order, RedirectAttributes redirectAttributes) throws Exception {
        Order oderPay = orderService.findByIdRent(order.getIdRent());
        if (oderPay == null) {
            throw new Exception();
        }
        Optional<Book> book = bookService.findById(oderPay.getBook().getId());
        bookService.payBook(book.get().getId());
        orderService.deleteOrder(oderPay);
        redirectAttributes.addFlashAttribute("message", "Pay book success");
        return "redirect:/book";
    }
}
