
package com.mightyfour.application;
import com.mightyfour.domain.Material;
import com.mightyfour.domain.MaterialRepository;
import java.util.List;
import java.util.ArrayList;



public class MaterialService{
    MaterialRepository repo1;

    public MaterialService(MaterialRepository repo1){
        this.repo1 = repo1;
    }

     public void createMaterial(String material_name, String recycling_instruction){
        repo1.save(new Material(material_name, recycling_instruction)); 
    }

    public List<String> listMaterials(){
         List<String> materialNames = new ArrayList<>(); 

        for(Material material : repo1.findAll()){
            materialNames.add(material.getName());
        }

        return materialNames;
    }

    public Material findMaterial(String material_name){
        return repo1.findMaterial(material_name);
    }

    //This initializes the supported materials for usage
    public void initMaterials(){


   
        //Here we define which materials the user can select from in the program
        createMaterial("Plastic", "Dispose of plastic waste in the bin 3 with the 'plastic packaging' label.");
        createMaterial("Paper", "Dispose of paper waste in the bin 2 with the 'paper packaging' label.");
       
       
    }

    
}