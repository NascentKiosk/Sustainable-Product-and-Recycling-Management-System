package com.mightyfour.domain;

public interface ImpactStrategyFactory{
    ImpactCalculationStrategy create(String choice);
}