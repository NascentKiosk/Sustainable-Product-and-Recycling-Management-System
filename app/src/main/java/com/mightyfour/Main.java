package com.mightyfour;

import com.mightyfour.presentation.Menu;
import com.mightyfour.application.MaterialService;
import com.mightyfour.infrastructure.In_memory_repository_material;



public class Main {
    public static void main(String[] args){

        In_memory_repository_material repo1 = new In_memory_repository_material();
        MaterialService serviceM = new MaterialService(repo1);
        Menu menu = new Menu(serviceM);

        menu.menuLoop();
        
    }
}
