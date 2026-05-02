package com.mightyfour.domain;
import java.util.ArrayList;


//Added helper class LIFESPAN
class LIFESPAN{

    private double DURATION;

    //Added a constructor for LIFESPAN
    public LIFESPAN(double DURATION){
        this.DURATION = DURATION;
    }

    //Added a getter for testing 
    public double get_duration(){
        return DURATION;
    }
}
    


public class Product {

    private String product_name;
    private ArrayList<Material> materials;

    private Category category;
    private LIFESPAN lifespan;

    public Product(String product_name, Material material, int duration){

        this.product_name = product_name;

        materials = new ArrayList<>();
        materials.add(material);

        lifespan = new LIFESPAN(duration);


       //this.category = new CATEGORY(CATEGORY_NAME);
      

    }

}

