package com.mightyfour.application;

import com.mightyfour.domain.ProductRepository;
import com.mightyfour.domain.Product;

public class ProductApplicationService {
    //ImpactCalculationStrategy strategy;
    ProductRepository repo;
    MaterialService serviceM;
    

    public ProductApplicationService(ProductRepository repo, MaterialService serviceM){
        this.repo = repo;
        this.serviceM = serviceM;
        //this.strategy = strategy;

    }

    public void createProduct(String product_name, String material_name, double duration){
        Product temp_product = new Product(product_name, serviceM.findMaterial(material_name), duration);
        repo.save(temp_product);
    }
    
    public void listProducts(){

    }

    public void getDetails(){

    }


    //public void calculateImpact(product){}


    public void addMaterial(){

      
    }

    public void createMaterial(){}
}
