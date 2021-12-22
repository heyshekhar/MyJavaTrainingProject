package com.eci.training.ui;

import java.util.Scanner;

import com.eci.training.domain.Product;
import com.eci.training.service.ProductService;
import com.eci.training.service.ProductServiceImpl;


public class ProductConsoleUI {
    
    ProductService service = new ProductServiceImpl();
    
    
    
    public void createProductWithUI() {
        
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String name = kb.nextLine();
        System.out.println("Enter price: ");
        float price = Float.parseFloat(kb.nextLine());
        System.out.println("Enter qoh: ");
        int qoh = Integer.parseInt(kb.nextLine());
        
        Product toBeSaved = new Product(name, price, qoh);
        
        int id = service.createNewProduct(toBeSaved);
        System.out.println("Created Product with Id: "+id);
        
        
    }

}
