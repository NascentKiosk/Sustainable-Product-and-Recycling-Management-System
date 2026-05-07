package com.mightyfour.infrastructure;
import java.util.ArrayList;
import java.util.List;

import com.mightyfour.domain.Material;
import com.mightyfour.domain.MaterialRepository;

public class In_memory_repository_material implements MaterialRepository {
     private List<Material> store = new ArrayList<>();


    public void save(Material material){
        store.add(material);
    }

    public List<Material> findAll(){
        return store;
    }

    public Material findMaterial(String material_name){


        for(Material material : store){
            if(material.getName().equals(material_name)){
                return material;
            }
        }

    
        throw new NullPointerException("Material with name '" + material_name + "' not found.");
    

    }

}
