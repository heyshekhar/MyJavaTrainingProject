package com.eci.training.service;

import java.util.List;


import com.eci.training.dal.InMemoryProductDAO;
import com.eci.training.dal.ProductDAO;
import com.eci.training.domain.Product;


public class ProductServiceImpl implements ProductService {
    
    ProductDAO dao = new InMemoryProductDAO();
    
    
    
    
    @Override
    public int createNewProduct(Product toBeSaved) {
        if(toBeSaved.getPrice() * toBeSaved.getQoh() >= 10000) {
            Product saved = dao.save(toBeSaved);
            return saved.getId();
        }else {
            throw new IllegalArgumentException("monetery value too low for a new product");
        }
         
    }

    @Override
    public Product findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public void removeProduct(int id) {
        //Product p = this.findById(id);
        Product existing = dao.findById(id);
        if(existing != null && existing.getPrice() * existing.getQoh() <= 1000) {
            dao.removeById(id);
        }
        
    }
    
    

}