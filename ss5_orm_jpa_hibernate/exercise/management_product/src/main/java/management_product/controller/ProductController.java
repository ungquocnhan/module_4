package management_product.controller;

import management_product.model.Product;
import management_product.repository.impl.ProductRepository;
import management_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") int id, RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete Success");
        return "redirect:/product";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<String> manufactureList = ProductRepository.manufactureList;
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("manufactureList", manufactureList);
        return "product/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Add Success");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        List<String> manufactureList = ProductRepository.manufactureList;
        model.addAttribute("product", product);
        model.addAttribute("manufactureList", manufactureList);
        return "product/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model){
        List<Product> productList = productService.findByName(name);
        model.addAttribute("productList", productList);
        model.addAttribute("name", name);
        return "product/list";
    }
}