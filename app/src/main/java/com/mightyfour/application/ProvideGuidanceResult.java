package com.mightyfour.application;
import java.util.ArrayList;

public class ProvideGuidanceResult {
    private ArrayList<String> messages;

    public ProvideGuidanceResult(ArrayList<String> messages){
        this.messages = messages;
    }


    public ArrayList<String> getMessages(){

        return messages;
    }
}
