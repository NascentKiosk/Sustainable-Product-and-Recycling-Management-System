package com.mightyfour.domain;
import java.util.ArrayList;

public interface ImpactCalculationStrategy {
    double calculateImpact(Product product, ArrayList<Double> materialWeights);
}
