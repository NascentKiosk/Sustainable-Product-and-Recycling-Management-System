package com.mightyfour;
import com.mightyfour.domain.RecyclingGuidance;
import com.mightyfour.domain.RecyclingGuidanceFactory;
import com.mightyfour.domain.Category;


public class DefaultRecyclingGuidanceFactory implements RecyclingGuidanceFactory{
    public RecyclingGuidance create(Category choice) {
        switch (choice) {
            case PAPER_PACKAGING: return new RecyclingGuidance("Paper ---> Put in blue trashbin.");
            case PLASTIC_PACKAGING: return new RecyclingGuidance("Plastic ---> Put in orange trashbin.");
            case ORGANIC_WASTE: return new RecyclingGuidance("Organic ---> Put in green/dark green trashbin.");
            case METAL_PACKAGING: return new RecyclingGuidance("Metal ---> Put in grey trashbin.");
            case GLASS_PACKAGING: return new RecyclingGuidance("Glass ---> Put in teal trashbin.");
            case SYNTETIC_TEXTILES: return new RecyclingGuidance("Non-organic textiles --> Put in light green trashbin.");
            default: throw new IllegalArgumentException();
        }
    }
}
