package com.mightyfour.application;

import com.mightyfour.domain.Material;
import java.util.ArrayList;
import java.util.UUID;


public class RetrieveProductDetailsResult{

    private String productName;
    private UUID productId;
    private String category;
    private double productLifespanDuration;
    private ArrayList<Material> productMaterials;

    public RetrieveProductDetailsResult(String productName, UUID productId, String category, double productLifespanDuration, ArrayList<Material> productMaterials){
        this.productName = productName;
        this.productId = productId;
        this.category = category;
        this.productLifespanDuration= productLifespanDuration;
        this.productMaterials = productMaterials;
    }

    public String getProductName(){
        return productName;
    }

    public UUID getProductId(){
        return productId;
    }

    public String getCategory(){
        return category;
    }

    public double getProductLifespanDuration(){
        return productLifespanDuration;
    }

    public ArrayList<Material> getProductMaterials(){
        return productMaterials;
    }


}