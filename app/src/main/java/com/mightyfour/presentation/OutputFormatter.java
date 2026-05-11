package com.mightyfour.presentation;

import java.util.List;
import java.util.ArrayList;
import com.mightyfour.application.ListMaterialsResult;
import com.mightyfour.application.ProvideGuidanceResult;

public class OutputFormatter {
    public void printListMaterialsResult(ListMaterialsResult result){

        System.out.println("List of current reusable materials: ");
        List<String> materialNames = result.getMaterialNames();

        for(String materialName : materialNames){
            System.out.println(materialName);
        }
    }

    public void printProvideGuidanceResult(ProvideGuidanceResult result) {
        ArrayList<String> instructions = result.getInstructions();

        System.out.println("Recycling instructions: \n");
        for(String instruction : instructions){
            System.out.println(instruction);
        }
        
        
    }
}
