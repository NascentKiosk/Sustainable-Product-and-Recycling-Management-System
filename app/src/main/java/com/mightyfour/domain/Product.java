package com.mightyfour.domain;
import java.util.ArrayList;
import java.util.UUID;


//Added helper class LIFESPAN
class LIFESPAN{

    private double DURATION;

    //Added a constructor for LIFESPAN
    public LIFESPAN(double DURATION){
        this.DURATION = DURATION;
    }

    //Added a getter for testing 
    public double getDuration(){
        return DURATION;
    }
}
    


public class Product {

    private UUID productId;
    private String product_name;
    private ArrayList<Material> materials;

    private Category category;
    private LIFESPAN lifespan;

    public Product(String product_name, Material material, double duration, UUID productId){

        this.product_name = product_name;

        materials = new ArrayList<>();
        materials.add(material);

        lifespan = new LIFESPAN(duration);


       //this.category = new CATEGORY(CATEGORY_NAME);
       this.productId = productId;
      

    }

    public String getName(){
        return product_name;
    }

    public UUID getId(){
        return productId;
    }

    public void addMaterial(Material material){
        if(canAddMaterial(material) == false){
            throw new DuplicateMaterialsException("The material with this name has already been added to Product.");
        }
         materials.add(material);
    }

     public double getLifespanDuration(){
        return lifespan.getDuration();
    }

    public ArrayList<Material> getMaterialsList(){
        return materials;
    }

    public boolean canAddMaterial(Material material){
        for(Material a : materials){
            if(a.getName().equals(material.getName())){
                return false;
            }
        }
       
        return true;
    }


}

