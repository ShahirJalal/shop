package com.example.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/addprod")
    public String index(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "addprod";
    }

    @PostMapping("/add")
    public String addproduct(Product product){
        service.saveprod(product);
        return "success";
    }

    @GetMapping("/getid")
    public String findid(Model model){
        Product product = new Product();
        int id = product.getId();
        model.addAttribute("product", product);
        service.getProdbyID(id);
        return "getbyid";
    }

    @PostMapping("/byid")
    public String findproduct(Model model, Product product, int id){
        //Product product = new Product();
        //int id = product.getId();
        service.printprod(product, model, id);
        return "result";
    }

    @GetMapping("/delete")
    public String deleteid(Model model){
        Product product = new Product();
        model.addAttribute("product", product);

        return "deletebyid";
    }
    @PostMapping("/deletebyid")
    public String deleteproduct(Product product){
        int id = product.getId();
        service.deleteProd(id);
        return "success";
    }

    @GetMapping("/update")
    public String updateprod(Model model){
        Product product = new Product();
        int id = product.getId();
        model.addAttribute("product", product);
        service.getProdbyID(id);
        return "updateprod";
    }

    @PostMapping("/edit")
    public String edited(Product product){
        service.updateProd(product);
        return "success";
    }
}