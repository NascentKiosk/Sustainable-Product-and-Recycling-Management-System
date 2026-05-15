package com.mightyfour.application;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import com.mightyfour.domain.Product;
import com.mightyfour.domain.ImpactStrategyFactory;
import com.mightyfour.domain.Material;
import com.mightyfour.domain.ProductRepository;
import com.mightyfour.domain.MaterialRepository;

public class ProductService {
    ProductRepository repo;
    MaterialRepository repo1;
    ImpactStrategyFactory factory;
    
   

    public ProductService(ProductRepository repo, MaterialRepository repo1, ImpactStrategyFactory factory){
        this.repo = repo;
        this.repo1 = repo1;
        this.factory = factory;
    }

    public ProvideImpactValueResult calculateImpact(UUID productId, String strategyNum){
        int result = (factory.create(strategyNum)).calculateImpact(repo.findProduct(productId));
        return new ProvideImpactValueResult(result);
    }

    public void createProduct(UUID productId, String product_name, Material material, double duration){
        
        Product temp_product = new Product(product_name, material, duration, productId);
        repo.save(temp_product);
        

    }
    
    public ArrayList<Material> addMaterialtoProduct(UUID productId, Material material){

        Product temp_Product = repo.findProduct(productId);
        temp_Product.addMaterial(material);

        return temp_Product.getMaterialsList();
    }
    

    public List<Product> findAll(){

        return repo.findAll();
    }

    //now app service does not need to access repositories - avoiding tight coupling
    public Product findProduct(UUID productId){

        return repo.findProduct(productId);
    }

    public String retrieveProductDetails(UUID productId){
        
        Product product = repo.findProduct(productId);

        String productName = product.getName();

        String productLifespanDurationString = Double.toString(product.getLifespanDuration());

        ArrayList<Material> productMaterials = product.getMaterialsList();
        ArrayList<String> productMaterialsString = new ArrayList<>();
        for(Material material : productMaterials){
            productMaterialsString.add(material.getName());
        }


       
        String tempString = "Name: " + productName + "\n ID: " + productId + "\n Category: " + product.getCategory()  + "\n Lifespan: " + productLifespanDurationString  + "\n Materials: ";

        for(String MaterialString : productMaterialsString){
            tempString += "\n   - " + MaterialString;
        }

        return tempString; //switch to dto object
    }

    public String retrieveProductsList(){
        String temp_string = "";
        for(Product product : repo.findAll()){
            temp_string += "Name: " + product.getName() + "\n" + "ID: " + product.getId().toString() + "\n";
        }


        return temp_string; //switch to dto object
    }

}
