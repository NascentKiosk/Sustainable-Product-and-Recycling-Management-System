package com.mightyfour.domain;
public class Material {
private String material_name;
private double impact_value; //not implemented yet
private String recycling_instruction;

    public Material(String material_name, String recycling_instruction){
        this.material_name = material_name;
        this.recycling_instruction = recycling_instruction;
        impact_value = 0;
    }
}

