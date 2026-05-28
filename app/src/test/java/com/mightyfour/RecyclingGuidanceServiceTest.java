import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import com.mightyfour.domain.Type;
import com.mightyfour.application.RecyclingGuidanceService;
import com.mightyfour.domain.Material;
import com.mightyfour.domain.RecyclingGuidanceFactory;


public class RecyclingGuidanceServiceTest {
        @Test
        public void shouldCorreclyReturnGuidanceMessageForPlastic(){
          //ARRANGE
          Material material = new Material("PVC Plastic", "Dispose of plastic waste in the bin 3 with the 'plastic packaging' label.", Type.PLASTIC , 2.1);
          ArrayList<Material> materials = new ArrayList<>();
          materials.add(material);


          //ACT
          RecyclingGuidanceService service = new RecyclingGuidanceService(new RecyclingGuidanceFactory());
          ArrayList<String> returnedMessages = service.retrieveMessages(materials);


          //ASSERT
          ArrayList<String> expectedMessages = new ArrayList<>();
          expectedMessages.add("Plastic ---> Put in grey trashbin");
        
          assertEquals(expectedMessages, returnedMessages);
        }


        @Test
        public void shouldCorreclyReturnGuidanceMessageForPaper(){
          //ARRANGE
          Material material = new Material("Paper", "Dispose of plastic waste in the bin 2 with the 'paper packaging' label.", Type.PAPER , 2.1);
          ArrayList<Material> materials = new ArrayList<>();
          materials.add(material);


          //ACT
          RecyclingGuidanceService service = new RecyclingGuidanceService(new RecyclingGuidanceFactory());
          ArrayList<String> returnedMessages = service.retrieveMessages(materials);


          //ASSERT
          ArrayList<String> expectedMessages = new ArrayList<>();
          expectedMessages.add("Paper ---> Put in blue trashbin.");
        
          assertEquals(expectedMessages, returnedMessages);
        }


        @Test
        public void shouldCorreclyReturnGuidanceMessageForMixed(){
          //ARRANGE
          Material paperA = new Material("Paper a", "Dispose of paper waste in the bin 2 with the 'paper packaging' label.", Type.PAPER , 0.4);
          Material plasticB = new Material("Plastic b", "Dispose of paper waste in the bin 3 with the 'plastic packaging' label.", Type.PLASTIC , 0.5);
          ArrayList<Material> materials = new ArrayList<>();
          materials.add(paperA);
          materials.add(plasticB);


          //ACT
          RecyclingGuidanceService service = new RecyclingGuidanceService(new RecyclingGuidanceFactory());
          ArrayList<String> returnedMessages = service.retrieveMessages(materials);


          //ASSERT
          ArrayList<String> expectedMessages = new ArrayList<>();
          expectedMessages.add("Plastic ---> Put in grey trashbin");
          expectedMessages.add("Paper ---> Put in blue trashbin.");
        
          assertEquals(expectedMessages, returnedMessages);
        }
}
