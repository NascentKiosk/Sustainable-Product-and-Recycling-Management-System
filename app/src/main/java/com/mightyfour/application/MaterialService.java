
package com.mightyfour.application;



public class MaterialService{
    MaterialRepository repo1;

    public MaterialService(MaterialRepository repo1){
        this.repo1 = repo1;
    }

     public void createMaterial(String material_name, String recycling_instruction){
        repo1.save(new Material(material_name, recycling_instruction)); 
    }

    public String listMaterials(){
        String temp_string = "";
        for(Material material : repo1.findAll()){
            temp_string += material.getName() + "\n";
        }

        return temp_string;
    }
    
}