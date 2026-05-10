package com.mightyfour.domain;

public enum Type {
    PAPER(Category.PAPER_PACKAGING),
    PLASTIC(Category.PLASTIC_PACKAGING),
    ORGANIC(Category.ORGANIC_WASTE), //belongs in organic
    NATURAL_TEXTILE(Category.ORGANIC_WASTE), //belongs in organic
    GLASS(Category.GLASS_PACKAGING), 
    METAL(Category.METAL_PACKAGING),
    SYNTETIC_TEXTILE(Category.SYNTETIC_TEXTILES);

    private Category category;

    Type(Category category){
        this.category = category;
    }

    public Category getCategory(){
        return category;
    }
   
}