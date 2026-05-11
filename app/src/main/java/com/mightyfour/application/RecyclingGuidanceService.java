package com.mightyfour.application;

import java.util.ArrayList;

import com.mightyfour.domain.Category;
import com.mightyfour.domain.Material;
import com.mightyfour.domain.Type;

public class RecyclingGuidanceService {


    public RecyclingGuidanceService(){
       
    }
    //Here instead of taking the product we are taking just the materials arraylist from product in order to respect text on github (UML needs to be changed too)
public ArrayList<String> retrieveInstructions(ArrayList<Material> materials){

        ArrayList<String> temp = new ArrayList<>();

        for(Material material : materials){
            if(!temp.contains(material.getInstruction())){
                temp.add(material.getInstruction());
            }
            
        }
        
        return temp;
}

public Category calculateCategory(ArrayList<Material> materials){
    
    ArrayList<Type> temp_list = new ArrayList<>();
   
    for(Material material : materials){
        if(!(temp_list.contains(material.getType()))){
            temp_list.add(material.getType());

        }
    }

    
    if(temp_list.size() > 1){
        return Category.MIXED_WASTE;
    }
    else{
        return temp_list.get(0).getCategory();
    }
        

   
}

}