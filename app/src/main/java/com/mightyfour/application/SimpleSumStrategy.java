package com.mightyfour.application;

import java.util.ArrayList;

import com.mightyfour.domain.ImpactCalculationStrategy;
import com.mightyfour.domain.Material;
import com.mightyfour.domain.Product;

public class SimpleSumStrategy implements ImpactCalculationStrategy {
    public int calculateImpact(Product product){

        ArrayList<Material> materialsList = product.getMaterialsList();

        int rawProductFootprint = 0;
        for(Material material : materialsList){
            rawProductFootprint += material.getImpact();
        }

        return rawProductFootprint;
    }
}
