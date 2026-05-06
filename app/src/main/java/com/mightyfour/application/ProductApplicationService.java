package com.mightyfour.application;

import com.mightyfour.domain.ProductRepository;

public class ProductApplicationService {
    //ImpactCalculationStrategy strategy;
    ProductRepository repo;
    MaterialService serviceM;
    

    public ProductApplicationService(ProductRepository repo, MaterialService serviceM){
        this.repo = repo;
        this.serviceM = serviceM;
        //this.strategy = strategy;

    }

    public void createProduct(){
        
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
