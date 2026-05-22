package com.mightyfour.domain;


public class RecyclingGuidanceFactory {
    public RecyclingGuidance create(Category choice) {
        switch (choice) {
            case PAPER_PACKAGING: return new RecyclingGuidance("Paper ---> Put in blue trashbin.");
            case PLASTIC_PACKAGING: return new RecyclingGuidance("Plastic ---> Put in grey trashbin");
            default: throw new IllegalArgumentException();
        }
    }
}