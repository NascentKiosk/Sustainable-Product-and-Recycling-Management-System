package com.mightyfour.presentation;

import java.util.List;
import com.mightyfour.application.ListMaterialsResult;

public class OutputFormatter {
    public void printListMaterialsResult(ListMaterialsResult result){

        System.out.println("List of current reusable materials: ");
        List<String> materialNames = result.getMaterialNames();

        for(String materialName : materialNames){
            System.out.println(materialName);
        }
    }
}
