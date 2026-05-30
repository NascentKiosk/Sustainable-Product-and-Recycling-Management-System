package com.mightyfour.application;

import com.mightyfour.domain.ImpactCalculationStrategy;
import com.mightyfour.domain.Product;
import com.mightyfour.domain.Material;
import java.util.ArrayList;

public class WeightedSumStrategy implements ImpactCalculationStrategy{
    public double calculateImpact(Product product, ArrayList<Double> materialWeights){
        ArrayList<Material> materialsList = product.getMaterialsList();


        double rawProductFootprint = 0;
        int count = 0;
        for(Material material : materialsList){
            rawProductFootprint += material.getImpact() * materialWeights.get(count);
            count++;
        }


        return rawProductFootprint;
    }
}
