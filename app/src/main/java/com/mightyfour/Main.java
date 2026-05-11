package com.mightyfour;

import com.mightyfour.presentation.Menu;
import com.mightyfour.presentation.OutputFormatter;

import java.util.Scanner;

import com.mightyfour.application.MaterialService;
import com.mightyfour.infrastructure.In_memory_repository_material;

import com.mightyfour.application.ProductApplicationService;
import com.mightyfour.application.RecyclingGuidanceService;
import com.mightyfour.infrastructure.In_memory_repository_product;



public class Main {
    public static void main(String[] args){

        In_memory_repository_product repo = new In_memory_repository_product(); 
        In_memory_repository_material repo1 = new In_memory_repository_material();

        MaterialService serviceM = new MaterialService(repo1);
        serviceM.initMaterials();
        
        RecyclingGuidanceService serviceR = new RecyclingGuidanceService();
        ProductApplicationService serviceP = new ProductApplicationService(repo, serviceM, serviceR);
        
        OutputFormatter formatter = new OutputFormatter();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(serviceM, serviceP, scanner, formatter);

        menu.menuLoop();
        
    }
}
