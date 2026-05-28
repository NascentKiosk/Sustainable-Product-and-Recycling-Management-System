package com.mightyfour;

import com.mightyfour.presentation.Menu;
import com.mightyfour.presentation.OutputFormatter;

import java.util.Scanner;

import com.mightyfour.application.MaterialService;
import com.mightyfour.application.ProductService;
import com.mightyfour.infrastructure.In_memory_repository_material;

import com.mightyfour.application.ApplicationService;
import com.mightyfour.application.RecyclingGuidanceService;
import com.mightyfour.infrastructure.In_memory_repository_product;
import com.mightyfour.domain.ImpactStrategyFactory;
import com.mightyfour.domain.RecyclingGuidanceFactory;

public class Main {
    public static void main(String[] args){

        In_memory_repository_product repo = new In_memory_repository_product(); 
        In_memory_repository_material repo1 = new In_memory_repository_material();

        MaterialService serviceM = new MaterialService(repo1);
        serviceM.initMaterials();
        
        ImpactStrategyFactory impactFactory = new DefaultImpactStrategyFactory();
        RecyclingGuidanceFactory guidanceFactory = new RecyclingGuidanceFactory();
        RecyclingGuidanceService serviceR = new RecyclingGuidanceService(guidanceFactory);
        ProductService serviceP = new ProductService(repo, repo1, impactFactory);
        ApplicationService serviceApp = new ApplicationService(serviceP, serviceM, serviceR);
        
        OutputFormatter formatter = new OutputFormatter();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(serviceApp, scanner, formatter);

        menu.menuLoop();
        
    }
}