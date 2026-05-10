package com.mightyfour.application;
import java.util.List;

public class ListMaterialsResult {
     private List<String> materialNames;

    public ListMaterialsResult(List<String> materialNames){
        this.materialNames = materialNames;
    }

    public List<String> getMaterialNames(){
        return materialNames;
    }

}
