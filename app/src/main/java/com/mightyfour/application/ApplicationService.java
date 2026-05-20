package com.mightyfour.application;

import java.util.UUID;
import java.util.ArrayList;

import com.mightyfour.domain.Product;
import com.mightyfour.domain.Material;

public class ApplicationService {
    //ImpactCalculationStrategy strategy;
    ProductService serviceP;
    MaterialService serviceM;
    RecyclingGuidanceService serviceR;
    

    public ApplicationService(ProductService serviceP, MaterialService serviceM, RecyclingGuidanceService serviceR){
        this.serviceP = serviceP;
        this.serviceM = serviceM;
        this.serviceR = serviceR;

    }

    public void createProduct(String productName, String materialName, double duration){
        UUID productId = UUID.randomUUID();
        serviceP.createProduct(productId, productName, serviceM.findMaterial(materialName), duration);

        Material material = serviceM.findMaterial(materialName);

        ArrayList<Material> materials = new ArrayList<>();
        materials.add(material);

        //Product temp = serviceP.findProduct(product_name);
        assignCategoryToProduct(materials, serviceP.findProduct(productId));

    }
    
    public String listProducts(){

        String tempString = serviceP.retrieveProductsList();
        return tempString; //dto object

    }

    public String displayProductDetails(String productId_string){
       
        UUID productId = UUID.fromString(productId_string);
        String tempString = serviceP.retrieveProductDetails(productId);
        
        return tempString;// dto object
    }
    
    //public void calculateImpact(product){}


    public void addMaterialtoProduct(String material_name, String productId_string){
        
        UUID productId = UUID.fromString(productId_string);

        Material tempMaterial = serviceM.findMaterial(material_name);

        Product tempProduct = serviceP.findProduct(productId);

        ArrayList<Material> materials = serviceP.addMaterialtoProduct(productId, tempMaterial);

        //Product temp = product_service.findProduct(product_name);
        assignCategoryToProduct(materials, tempProduct);

        
      
    }

    public ListMaterialsResult listPredefinedMaterials(){
        return new ListMaterialsResult(serviceM.listMaterials());
    }

    public void assignCategoryToProduct(ArrayList<Material> materials, Product product){
        //Category temp = recycling_service.get_category(materials);
        product.assignCategory(serviceR.calculateCategory(materials));
        
    }

    public ProvideGuidanceResult provideGuidance(String productId_string){

        UUID productId = UUID.fromString(productId_string);

        Product tempProduct = serviceP.findProduct(productId);

        ArrayList<Material> tempMaterials = tempProduct.getMaterialsList();

        ArrayList<String> allInstructions = serviceR.retrieveInstructions(tempMaterials);

        return new ProvideGuidanceResult(allInstructions);

    }

    public ProvideImpactValueResult provideImpactValue(String productId_string, String strategyNum){
        UUID productId = UUID.fromString(productId_string);
        return serviceP.calculateImpact(productId, strategyNum);
    }

}

