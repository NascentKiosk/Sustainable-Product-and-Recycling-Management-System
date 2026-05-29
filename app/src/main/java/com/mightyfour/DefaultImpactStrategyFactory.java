package com.mightyfour;

import com.mightyfour.domain.ImpactStrategyFactory;
import com.mightyfour.domain.ImpactCalculationStrategy;
import com.mightyfour.application.SimpleSumStrategy;
import com.mightyfour.application.WeightedSumStrategy;

public class DefaultImpactStrategyFactory implements ImpactStrategyFactory {
    public ImpactCalculationStrategy strategy;
    public ImpactCalculationStrategy create(String choice) {
        switch (choice) {
            case "1": return new SimpleSumStrategy();
            case "2": return new WeightedSumStrategy();
            default: throw new IllegalArgumentException();
}
}
}