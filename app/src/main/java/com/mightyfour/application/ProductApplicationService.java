package com.mightyfour.application;

import com.mightyfour.domain.MaterialRepository;
import com.mightyfour.domain.ProductRepository;

public class ProductApplicationService {
    //ImpactCalculationStrategy strategy;
    ProductRepository repo;
    MaterialRepository repo1;
    

    public ProductApplicationService(ProductRepository repo, MaterialRepository repo1){
        this.repo = repo;
        this.repo1 = repo1;
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
