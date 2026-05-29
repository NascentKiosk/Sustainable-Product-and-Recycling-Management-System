package com.mightyfour.presentation;

import java.util.List;
import java.util.ArrayList;
import com.mightyfour.application.ListMaterialsResult;
import com.mightyfour.application.ProvideGuidanceResult;
import com.mightyfour.application.ProvideImpactValueResult;
import com.mightyfour.application.DisplayProductDetailsResult;

public class OutputFormatter {
    public void printListMaterialsResult(ListMaterialsResult result){

        System.out.println("List of current reusable materials: ");
        List<String> materialNames = result.getMaterialNames();

        for(String materialName : materialNames){
            System.out.println(materialName);
        }
    }

    public void printProvideGuidanceResult(ProvideGuidanceResult result) {
        ArrayList<String> messages = result.getMessages();

        System.out.println("How to recycle the specified Product: \n");
        for(String message : messages){
            System.out.println(message);
        }
        
        
    }

    public void printImpactValueResult(ProvideImpactValueResult result){
        System.out.println("Result of calculation: " + result.getResult());
    }
    
    public void printDisplayProductDetailsResult(DisplayProductDetailsResult result){
         String formattedString = "Name: " + result.getProductName() + "\n ID: " + result.getProductId() + "\n Category: " + result.getCategory()  + "\n Lifespan: " + result.getProductLifespanDuration() + "\n Materials: ";

        for(String materialName : result.getMaterialNames()){
            formattedString += "\n   - " + materialName;
        }

        System.out.println(formattedString);
    }
}
