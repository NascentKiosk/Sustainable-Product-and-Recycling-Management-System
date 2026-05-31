package com.mightyfour.application;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
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

    public ProvideImpactValueResult calculateImpact(UUID productId, String strategyNum, ArrayList<Double> materialWeights){
        double result = (factory.create(strategyNum)).calculateImpact(repo.findProduct(productId), materialWeights);
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

    public RetrieveProductDetailsResult retrieveProductDetails(UUID productId){
        
        Product product = repo.findProduct(productId);

        String productName = product.getName();

        double productLifespanDuration = product.getLifespanDuration();

        ArrayList<Material> productMaterials = product.getMaterialsList();


       
        //String tempString = "Name: " + productName + "\n ID: " + productId + "\n Category: " + product.getCategory()  + "\n Lifespan: " + productLifespanDurationString  + "\n Materials: ";


        return new RetrieveProductDetailsResult(productName, productId, product.getCategory().toString(), productLifespanDuration, productMaterials);
    }

    public HashMap<UUID, String> retrieveProductsList(){
        HashMap<UUID, String> productNamesAndUUIDs = new HashMap<>();

        for(Product product : repo.findAll()){
            productNamesAndUUIDs.put(product.getId(), product.getName());
        }


        return productNamesAndUUIDs; 
    }

}
