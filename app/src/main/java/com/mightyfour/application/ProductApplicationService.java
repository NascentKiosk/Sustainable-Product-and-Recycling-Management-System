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
    RecyclingGuidanceService serviceR;
    

    public ProductApplicationService(ProductRepository repo, MaterialService serviceM, RecyclingGuidanceService serviceR){
        this.repo = repo;
        this.serviceM = serviceM;
        this.serviceR = serviceR;
        //this.strategy = strategy;

    }

    public void createProduct(String product_name, String material_name, double duration){
        UUID tempId = UUID.randomUUID();
        Product tempProduct = new Product(product_name, serviceM.findMaterial(material_name), duration, tempId);

        repo.save(tempProduct); 

        ArrayList<Material> materials = tempProduct.getMaterialsList();

        //Product temp = product_service.findProduct(product_name);
        assignCategoryToProduct(materials, repo.findProduct(tempProduct.getId()));

        
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
       
        String tempString = "Name: " + productName + "\n ID: " + productId_string + "\n Category: " + product.getCategory()  + "\n Lifespan: " + productLifespanDurationString  + "\n Materials: ";

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

        ArrayList<Material> materials = tempProduct.getMaterialsList();

        //Product temp = product_service.findProduct(product_name);
        assignCategoryToProduct(materials, tempProduct);

        
      
    }

    public void createMaterial(){}

     public ListMaterialsResult listPredefinedMaterials(){
        return new ListMaterialsResult(serviceM.listMaterials());
    }

    public void assignCategoryToProduct(ArrayList<Material> materials, Product product){
        //Category temp = recycling_service.get_category(materials);
        product.assignCategory(serviceR.calculateCategory(materials));
        
    }

    public ProvideGuidanceResult provideGuidance(String productId_string){

        UUID productId = UUID.fromString(productId_string);

        Product tempProduct = repo.findProduct(productId);

        ArrayList<Material> tempMaterials = tempProduct.getMaterialsList();

        ArrayList<String> allInstructions = serviceR.retrieveInstructions(tempMaterials);

        return new ProvideGuidanceResult(allInstructions);

    }

}
