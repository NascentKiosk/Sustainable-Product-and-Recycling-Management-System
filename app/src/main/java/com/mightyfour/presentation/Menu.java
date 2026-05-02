package com.mightyfour.presentation;
import java.util.Scanner;

public class Menu {
    //private ImpactCalculationStrategy strategy;
    private Scanner input;

    public Menu(){
        this.input = new Scanner(System.in);
    }


    
    public void menuLoop(){}


    public String readInput(){

        String user_response = input.nextLine();
        return user_response;
    }

    public void printOutput(String string){
        System.out.print(string);
    }
}
