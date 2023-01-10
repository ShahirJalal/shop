package com.example.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public Product saveprod(Product product){
        return repo.save(product);
    }

    public Product getProdbyID(int id){
        return repo.findById(id).orElse(null);
    }

    public String deleteProd(int id){
        repo.deleteById(id);
        return "index";
    }

    public Product printprod(Product product, Model model, int id){
        product = repo.findById(id).orElse(null);
        model.addAttribute("msgid", product.getId());
        model.addAttribute("msgname", product.getName());
        model.addAttribute("msgquantity", product.getQuantity());
        model.addAttribute("msgprice", product.getPrice());
        return product;
    }

    public Product updateProd(Product product){
        Product currentprod = repo.findById(product.getId()).orElse(null);
        currentprod.setName(product.getName());
        currentprod.setQuantity(product.getQuantity());
        currentprod.setPrice(product.getPrice());

        return repo.save(currentprod);
    }

}