package com.mightyfour;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.UUID;

import com.mightyfour.domain.Product;
import com.mightyfour.domain.Type;
import com.mightyfour.domain.Material;
import com.mightyfour.domain.Category;

public class ProductTest {
    @Test
    public void shouldCorrectlyStoreAndReturnItsName(){
        //ARRANGE
        Material material = new Material("Plastic C", "Throw away outside of building.", Type.PLASTIC, 1.0);
        UUID productId = UUID.randomUUID();
                                       
        //ACT
        Product product = new Product("Plate", material , 0, productId);

        //ASSERT
        String result = product.getName();
        assertEquals("Plate", result);
                                                                                       
    }

    //if name is empty or null

    @Test
    public void shouldCorrectlyStoreAndReturnItsCategory(){
        //ARRANGE
        Material material = new Material("Plastic C", "Throw away outside of building.", Type.PLASTIC, 1.0);
        UUID productId = UUID.randomUUID();
        Category category = Category.PLASTIC_PACKAGING;
        Product product = new Product("Plate", material , 0, productId);
                                                                                                                                                       
        //ACT
        product.assignCategory(category);
        Category result = product.getCategory();

        //ASSERT
        assertEquals(Category.PLASTIC_PACKAGING, result);
                                                                                                                                                                                                       
    }

    @Test
    public void shouldCorrectlyStoreMaterialAndReturnListOfItsMaterials(){
        //ARRANGE
        Material material = new Material("Plastic C", "Throw away outside of building.", Type.PLASTIC, 1.0);
        UUID productId = UUID.randomUUID();
        Product product = new Product("Plate", material , 0, productId);

        //ACT
        ArrayList<Material> materials = product.getMaterialsList();

        //ASSERT
        ArrayList<Material> expectedMaterials = new ArrayList<Material>();
        expectedMaterials.add(material);
        assertEquals(expectedMaterials, materials);

    }  
   
    @Test
    public void shouldCorrectlyAddMaterialToExistingProductAndReturnListOfItsMaterials(){
        //ARRANGE
        Material plasticB = new Material("Plastic B", "Throw away in a bin outside of building.", Type.PLASTIC, 1.0);
        Material paperD = new Material("Paper D", "Roll each sheet into an airplane and test the power of wind through the window.", Type.PAPER, 1.0);
        UUID productId = UUID.randomUUID();
        Product product = new Product("Plate", plasticB , 0, productId);
        //ACT
        product.addMaterial(paperD);
        ArrayList<Material> materials = product.getMaterialsList();
        //ASSERT
        ArrayList<Material> expectedMaterials = new ArrayList<Material>();
        expectedMaterials.add(plasticB);
        expectedMaterials.add(paperD);
        assertEquals(expectedMaterials, materials);
    }




    @Test
    public void shouldCorrectlyStoreAndReturnItsLifespan(){
        //ARRANGE
        Material paperD = new Material("Paper D", "Roll each sheet into an airplane and test the power of wind through the window.", Type.PAPER, 1.0);
        UUID productId = UUID.randomUUID();
        Product product = new Product("Plate", paperD , 17, productId);
        //ACT
        double lifespanDuration = product.getLifespanDuration();
        //ASSERT
        assertEquals(17, lifespanDuration, 0);
    }
}
