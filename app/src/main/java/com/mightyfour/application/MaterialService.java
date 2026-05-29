package com.mightyfour.application;
import com.mightyfour.domain.Type;
import com.mightyfour.domain.Material;
import com.mightyfour.domain.MaterialRepository;
import java.util.List;
import java.util.ArrayList;



public class MaterialService{
    MaterialRepository repo1;

    public MaterialService(MaterialRepository repo1){
        this.repo1 = repo1;
    }

     public void createMaterial(String material_name, String recycling_instruction, Type type, double impactValue){
        repo1.save(new Material(material_name, recycling_instruction, type, impactValue)); 
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
        createMaterial("PET Plastic", "Dispose of plastic waste in the bin with the 'plastic packaging' label.", Type.PLASTIC, 3.5);
        createMaterial("HDPE Plastic", "Dispose of paper waste in the bin with the 'paper packaging' label.", Type.PLASTIC , 2.0 );
        createMaterial("PVC Plastic", "Dispose of plastic waste in the bin with the 'plastic packaging' label.", Type.PLASTIC, 2.1);
        createMaterial("Recycled Paperboard", "Dispose of paper waste in the bin with the 'paper packaging' label.", Type.PAPER , 0.50 );
        
        createMaterial("Virgin Aluminum", "Dispose of metal waste in the bin with the 'metal packaging' label.", Type.METAL , 12.0);
        createMaterial("Recycled Aluminum", "Dispose of metal waste in the bin with the 'metal packaging' label.", Type.METAL , 1.5);
        createMaterial("Virgin Steel", "Dispose of metal waste in the bin with the 'metal packaging' label.", Type.METAL , 2.2);
        createMaterial("Recycled Steel", "Dispose of metal waste in the bin with the 'metal packaging' label.", Type.METAL , 0.4);

        createMaterial("Virgin Glass", "Dispose of glass waste in the bin with the 'glass packaging' label.", Type.GLASS , 1.1);
        createMaterial("Recycled Glass", "Dispose of glass waste in the bin with the 'glass packaging' label.", Type.GLASS , 0.64);

        createMaterial("Sorona", "Dispose of synthetic textiles in the bin with the 'synthetic textile' label.", Type.SYNTETIC_TEXTILE , 3.3);
        createMaterial("Natural Rubber", "Dispose of organic waste in the bin with the 'organic waste' label.", Type.ORGANIC , 1.3);

        createMaterial("Fleece", "Dispose of synthetic textiles in the bin with the 'synthetic textile' label.", Type.SYNTETIC_TEXTILE, 8.7);
        createMaterial("Pure Merino Wool", "Dispose of organic waste in the bin with the 'organic waste' label.", Type.NATURAL_TEXTILE, 65); //impactValue = avg of 50 and 80.

        

       
       
    
    }

    
} 
