package com.mightyfour.application;

import com.mightyfour.domain.ProductRepository;

import java.util.UUID;
import java.util.ArrayList;

import com.mightyfour.domain.Product;
import com.mightyfour.domain.Material;

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
        UUID tempId = UUID.randomUUID();
        Product temp_product = new Product(product_name, serviceM.findMaterial(material_name), duration, tempId);
        repo.save(temp_product);
    }
    
    public String listProducts(){
        String temp_string = "";
        for(Product product : repo.findAll()){
            temp_string += "Name: " + product.getName() + "\n" + "ID: " + product.getId().toString() + "\n\n";
        }


        return temp_string;
    }

    public String displayProductDetails(String productId_string){
       
        
        UUID productId = UUID.fromString(productId_string);
        Product product = repo.findProduct(productId);

        String productName = product.getName();

        String productLifespanDurationString = Double.toString(product.getLifespanDuration());

        ArrayList<Material> productMaterials = product.getMaterialsList();
        ArrayList<String> productMaterialsString = new ArrayList<>();
        for(Material material : productMaterials){
            productMaterialsString.add(material.getName());
        }
       
        String tempString = "Name: " + productName + "\n ID: " + productId_string + "\n Lifespan: " + productLifespanDurationString  + "\n Materials: ";

        for(String MaterialString : productMaterialsString){
            tempString += "\n   - " + MaterialString;
        }
        return tempString;
        
    }
    
    //public void calculateImpact(product){}


    public void addMaterialtoProduct(String material_name, String productId_string){
        
        UUID productId = UUID.fromString(productId_string);

        Material temp_Material = serviceM.findMaterial(material_name);

        Product tempProduct = repo.findProduct(productId);

        tempProduct.addMaterial(temp_Material);
      
    }

    public void createMaterial(){}

}
