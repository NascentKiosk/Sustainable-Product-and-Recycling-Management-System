package com.mightyfour.application;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import com.mightyfour.domain.RecyclingGuidance;
import com.mightyfour.domain.RecyclingGuidanceFactory;
import com.mightyfour.domain.Category;
import com.mightyfour.domain.Material;
import com.mightyfour.domain.Type;


public class RecyclingGuidanceService {

    RecyclingGuidanceFactory guidance;

    public RecyclingGuidanceService(RecyclingGuidanceFactory guidance){
        this.guidance = guidance;
       
    }
    //Here instead of taking the product we are taking just the materials arraylist from product in order to respect text on github (UML needs to be changed too)
public ArrayList<String> retrieveMessages(ArrayList<Material> materials){

        ArrayList<String> finalVerdict = new ArrayList<>(); 
        Set<Category> categoriesDetected = new HashSet<>(); 
        for(Material material : materials){ 
            categoriesDetected.add(material.getType().getCategory()); } 
        for(Category category : categoriesDetected){
            finalVerdict.add(guidance.create(category).getMessage()); 
            }
        
        return finalVerdict;
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