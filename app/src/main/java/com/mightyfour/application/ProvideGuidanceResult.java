package com.mightyfour.application;
import java.util.ArrayList;

public class ProvideGuidanceResult {
    private ArrayList<String> instructions;

    public ProvideGuidanceResult(ArrayList<String> instructions){
        this.instructions = instructions;
    }


    public ArrayList<String> getInstructions(){

        return instructions;
    }
}
