package com.mightyfour.application;
import java.util.ArrayList;

public class DisplayProductDetailsResult{

    private String productName;
    private String productId;
    private String category;
    private double productLifespanDuration;
    private ArrayList<String> materialNames;

    public DisplayProductDetailsResult(String productName, String productId, String category, double productLifespanDuration, ArrayList<String> materialNames){
        this.productName = productName;
        this.productId = productId;
        this.category = category;
        this.productLifespanDuration= productLifespanDuration;
        this.materialNames = materialNames;
    }

    public String getProductName(){
        return productName;
    }

    public String getProductId(){
        return productId;
    }

    public String getCategory(){
        return category;
    }

    public double getProductLifespanDuration(){
        return productLifespanDuration;
    }

    public ArrayList<String> getMaterialNames(){
        return materialNames;
    }






}