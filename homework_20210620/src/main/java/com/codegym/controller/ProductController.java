package com.codegym.controller;

import com.codegym.exception.ProductNotFoundException;
import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Pageable;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("cart")
    private Cart cart() {
        return new Cart();
    }

    @GetMapping
    public ModelAndView showIndex(Pageable pageable, @RequestParam Optional<String> q) {
        ModelAndView modelAndView = new ModelAndView("product/index");
        Page<Product> products;
        String query;
        if (q.isPresent()) {
            products = productService.findAllByNameContaining(q.get(), pageable);
            query = q.get();
        } else {
            products = productService.findAll(pageable);
            query = "";
        }
        modelAndView.addObject("products", products);
        modelAndView.addObject("q", query);
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.addObject("newProductForm", new ProductForm());
        return modelAndView;
    }

    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductForm newProductForm) {
        MultipartFile file = newProductForm.getImage();
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Product newProduct = new Product(newProductForm.getId(), newProductForm.getName(), newProductForm.getCategory(), fileName);
        productService.save(newProduct);
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("product/view");
        Product product = null;
        try {
            product = productService.findById(id).get();
        } catch (ProductNotFoundException e) {
            return new ModelAndView("/product/error");
        }
        modelAndView.addObject("product", product);
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, @RequestParam MultipartFile imageFile) {
        String fileName = imageFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(imageFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        product.setImage(fileName);
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/remove")
    public String removeProduct(@PathVariable Long id) {
        productService.remove(id);
        return "redirect:/product";
    }

    @GetMapping("/{id}/add")
    public String addProductToCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = null;
        try {
            productOptional = productService.findById(id);
        } catch (ProductNotFoundException e) {
            return "/product/error";
        }
        if (!productOptional.isPresent()) {
            return "/product/error";
        }
        cart.add(productOptional.get());
        return "redirect:/product";
    }
}
