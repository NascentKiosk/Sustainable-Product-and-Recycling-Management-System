package com.mightyfour.domain;
public class Material {
private String material_name;
private double impact_value; //not implemented yet
private String recycling_instruction;
private Type type;

    public Material(String material_name, String recycling_instruction, Type type){
        this.material_name = material_name;
        this.recycling_instruction = recycling_instruction;
        this.type = type;
        impact_value = 0;
    }

    public String getName(){ //Getter
        return material_name;
    }

    public Type getType(){
        return type;
    }

    public String getInstruction(){ 
        return recycling_instruction;
    }
}

