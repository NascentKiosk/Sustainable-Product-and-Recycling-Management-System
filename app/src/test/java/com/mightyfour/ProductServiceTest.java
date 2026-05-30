package com.mightyfour;


import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.UUID;


import com.mightyfour.domain.Product;
import com.mightyfour.domain.Type;
import com.mightyfour.domain.Material;
import com.mightyfour.application.ProductService;
import com.mightyfour.domain.Category;


public class ProductServiceTest{

    @Test
    public void shouldCorrectlyCalculateImpactViaSimpleSum(){
        //ARRANGE

        Material fabricA = new Material("Sorona", "Dispose of synthetic textiles in the bin with the 'synthetic textile' label.", Type.SYNTETIC_TEXTILE , 3.3);
        Material fabricB = new Material("Fleece", "Dispose of synthetic textiles in the bin with the 'synthetic textile' label.", Type.SYNTETIC_TEXTILE, 8.7);
        UUID productId = UUID.randomUUID();
        Product product = new Product("Shirt", fabricA, 10, productId);
        product.addMaterial(fabricB);

        ProductRepository repo = new In_memory_repository_product();
        MaterialRepository repo1 = new In_memory_repository_material();
        ImpactStrategyFactory factory = new DefaultImpactStrategyFactory();
        ProductService service = new ProductService(repo, repo1, factory);

        //ACT
        int result = service.calculateImpact(product.getId(), 1); 

        //ASSERT
        assertEquals(12, result);
    }
}