package com.mightyfour;


import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.UUID;


import com.mightyfour.domain.Product;
import com.mightyfour.domain.Type;
import com.mightyfour.domain.Material;
import com.mightyfour.domain.Category;


public class MaterialTest{
        @Test
        public void shouldCorrectlyStoreAndReturnItsName(){


            //ARRANGE
            String name = "PVC Plastic";
            String instruction = "Toss in bin for plastic.";
            Type type = Type.PLASTIC;
            Material material = new Material(name, instruction, type, 1.0);


            //ACT
            String returnedName = material.getName();


            //ASSERT
            assertEquals(name, returnedName);
        }


        @Test
        public void shouldCorrectlyStoreAndReturnItsImpactValue(){


            //ARRANGE
            String name = "PVC Plastic";
            String instruction = "Toss in bin for plastic.";
            Type type = Type.PLASTIC;
            double impactValue = 2.1;
            Material material = new Material(name, instruction, type, impactValue);
            //ACT
            double returnedImpactValue = material.getImpact();
            //ASSERT
            assertEquals(impactValue, returnedImpactValue, 0);
            //0 is lamba (the precision value)
        }


        @Test
        public void shouldCorrectlyStoreAndReturnItsRecyclingInstruction(){


            //ARRANGE
            String name = "PVC Plastic";
            String instruction = "Toss in bin for plastic.";
            Type type = Type.PLASTIC;
            Material material = new Material(name, instruction, type, 2.2);


            //ACT
            String returnedInstruction = material.getInstruction();


            //ASSERT
            assertEquals(instruction, returnedInstruction);
        }
}
