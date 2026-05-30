package com.mightyfour.application;

import com.mightyfour.domain.ImpactCalculationStrategy;
import com.mightyfour.domain.Product;
import java.util.ArrayList;

public class WeightedSumStrategy implements ImpactCalculationStrategy{
    public double calculateImpact(Product product, ArrayList<Double> materialWeights){
        return 0.0; //Not implemented yet.
    }
}
