package com.mightyfour.domain;
public class Material {
private String materialName;
private double impactValue; //not implemented yet
private String recyclingInstruction;
private Type type;

    public Material(String materialName, String recyclingInstruction, Type type, double impactValue){
        this.materialName = materialName;
        this.recyclingInstruction = recyclingInstruction;
        this.type = type;
        this.impactValue = impactValue;
    }

    public String getName(){ //Getter
        return materialName;
    }

    public Type getType(){
        return type;
    }

    public String getInstruction(){ 
        return recyclingInstruction;
    }

    public double getImpact(){
        return impactValue;
    }
}

