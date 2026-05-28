import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import com.mightyfour.domain.Type;
import com.mightyfour.application.RecyclingGuidanceService;
import com.mightyfour.DefaultRecyclingGuidanceFactory;
import com.mightyfour.domain.Material;
import com.mightyfour.domain.RecyclingGuidanceFactory;


public class RecyclingGuidanceServiceTest {
        @Test
        public void shouldCorreclyReturnGuidanceMessageForPlastic(){
          //ARRANGE
          Material material = new Material("PET Plastic", "Dispose of plastic waste in the bin with the 'plastic packaging' label.", Type.PLASTIC, 3.5);
          ArrayList<Material> materials = new ArrayList<>();
          materials.add(material);


          //ACT
          RecyclingGuidanceService service = new RecyclingGuidanceService(new DefaultRecyclingGuidanceFactory());
          ArrayList<String> returnedMessages = service.retrieveMessages(materials);


          //ASSERT
          ArrayList<String> expectedMessages = new ArrayList<>();
          expectedMessages.add("Plastic ---> Put in orange trashbin.");
        
          assertEquals(expectedMessages, returnedMessages);
        }


        @Test
        public void shouldCorreclyReturnGuidanceMessageForPaper(){
          //ARRANGE
          Material material = new Material("Recycled Paperboard", "Dispose of paper waste in the bin with the 'paper packaging' label.", Type.PAPER , 0.50); 
          ArrayList<Material> materials = new ArrayList<>();
          materials.add(material);


          //ACT
          RecyclingGuidanceService service = new RecyclingGuidanceService(new DefaultRecyclingGuidanceFactory());
          ArrayList<String> returnedMessages = service.retrieveMessages(materials);


          //ASSERT
          ArrayList<String> expectedMessages = new ArrayList<>();
          expectedMessages.add("Paper ---> Put in blue trashbin.");
        
          assertEquals(expectedMessages, returnedMessages);
        }

        public void shouldCorreclyReturnGuidanceMessageForMetal(){
          //ARRANGE
          Material material = new Material("Virgin Aluminum", "Dispose of metal waste in the bin with the 'metal packaging' label.", Type.METAL , 12.0);;
          ArrayList<Material> materials = new ArrayList<>();
          materials.add(material);


          //ACT
          RecyclingGuidanceService service = new RecyclingGuidanceService(new DefaultRecyclingGuidanceFactory());
          ArrayList<String> returnedMessages = service.retrieveMessages(materials);


          //ASSERT
          ArrayList<String> expectedMessages = new ArrayList<>();
          expectedMessages.add("Metal ---> Put in grey trashbin.");
        
          assertEquals(expectedMessages, returnedMessages);
        }

        public void shouldCorreclyReturnGuidanceMessageForGlass(){
          //ARRANGE
          Material material = new Material("Virgin Glass", "Dispose of glass waste in the bin with the 'glass packaging' label.", Type.GLASS , 1.1);
          ArrayList<Material> materials = new ArrayList<>();
          materials.add(material);


          //ACT
          RecyclingGuidanceService service = new RecyclingGuidanceService(new DefaultRecyclingGuidanceFactory());
          ArrayList<String> returnedMessages = service.retrieveMessages(materials);


          //ASSERT
          ArrayList<String> expectedMessages = new ArrayList<>();
          expectedMessages.add("Glass ---> Put in teal trashbin.");
        
          assertEquals(expectedMessages, returnedMessages);
        }

        public void shouldCorreclyReturnGuidanceMessageForOrganic(){
          //ARRANGE
          Material material = new Material("Natural Rubber", "Dispose of organic waste in the bin with the 'organic waste' label.", Type.ORGANIC , 1.3);
          ArrayList<Material> materials = new ArrayList<>();
          materials.add(material);


          //ACT
          RecyclingGuidanceService service = new RecyclingGuidanceService(new DefaultRecyclingGuidanceFactory());
          ArrayList<String> returnedMessages = service.retrieveMessages(materials);


          //ASSERT
          ArrayList<String> expectedMessages = new ArrayList<>();
          expectedMessages.add("Organic ---> Put in green/dark green trashbin.");
        
          assertEquals(expectedMessages, returnedMessages);
        }

        public void shouldCorreclyReturnGuidanceMessageForTextiles(){
          //ARRANGE
          Material material = new Material("Fleece", "Dispose of synthetic textiles in the bin with the 'synthetic textile' label.", Type.SYNTETIC_TEXTILE, 8.7);
          ArrayList<Material> materials = new ArrayList<>();
          materials.add(material);


          //ACT
          RecyclingGuidanceService service = new RecyclingGuidanceService(new DefaultRecyclingGuidanceFactory());
          ArrayList<String> returnedMessages = service.retrieveMessages(materials);


          //ASSERT
          ArrayList<String> expectedMessages = new ArrayList<>();
          expectedMessages.add("Non-organic textiles --> Put in light green trashbin.");
        
          assertEquals(expectedMessages, returnedMessages);
        }

        @Test
        public void shouldCorreclyReturnGuidanceMessageForMixed(){
          //ARRANGE
          Material paperA = new Material("Recycled Paperboard", "Dispose of paper waste in the bin with the 'paper packaging' label.", Type.PAPER , 0.50);
          Material plasticB = new Material("PET Plastic", "Dispose of plastic waste in the bin with the 'plastic packaging' label.", Type.PLASTIC, 3.5);
          ArrayList<Material> materials = new ArrayList<>();
          materials.add(paperA);
          materials.add(plasticB);


          //ACT
          RecyclingGuidanceService service = new RecyclingGuidanceService(new DefaultRecyclingGuidanceFactory());
          ArrayList<String> returnedMessages = service.retrieveMessages(materials);


          //ASSERT
          ArrayList<String> expectedMessages = new ArrayList<>();
          expectedMessages.add("Paper ---> Put in blue trashbin.");
          expectedMessages.add("Plastic ---> Put in orange trashbin.");
        
          assertEquals(expectedMessages, returnedMessages);
        }
}
