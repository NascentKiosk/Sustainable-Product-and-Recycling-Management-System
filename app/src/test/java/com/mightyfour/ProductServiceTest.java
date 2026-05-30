package com.mightyfour;


import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.UUID;


import com.mightyfour.domain.Product;
import com.mightyfour.domain.Type;
import com.mightyfour.domain.Material;
import com.mightyfour.application.ProductService;
import com.mightyfour.application.ProvideImpactValueResult;
import com.mightyfour.domain.Category;
import com.mightyfour.domain.ImpactStrategyFactory;
import com.mightyfour.domain.MaterialRepository;
import com.mightyfour.domain.ProductRepository;
import com.mightyfour.infrastructure.In_memory_repository_material;
import com.mightyfour.infrastructure.In_memory_repository_product;


public class ProductServiceTest{

    @Test
    public void shouldCorrectlyCalculateImpactViaSimpleSum(){
        //ARRANGE
        ProductRepository repo = new In_memory_repository_product();
        MaterialRepository repo1 = new In_memory_repository_material();
        ImpactStrategyFactory factory = new DefaultImpactStrategyFactory();
        ProductService service = new ProductService(repo, repo1, factory);

        Material fabricA = new Material("Sorona", "Dispose of synthetic textiles in the bin with the 'synthetic textile' label.", Type.SYNTETIC_TEXTILE , 3.3);
        Material fabricB = new Material("Fleece", "Dispose of synthetic textiles in the bin with the 'synthetic textile' label.", Type.SYNTETIC_TEXTILE, 8.7);
        UUID productId = UUID.randomUUID();
        Product product = new Product("Shirt", fabricA, 10, productId);
        repo.save(product);
        product.addMaterial(fabricB);

        //ACT
        ProvideImpactValueResult result = service.calculateImpact(product.getId(), "1", new ArrayList<Double>()); 
        double impactValue = result.getResult();

        //ASSERT
        assertEquals(12.0, impactValue, 0);
    }

    @Test
    public void shouldCorrectlyCalculateImpactViaWeightedSum(){
        //ARRANGE
        ProductRepository repo = new In_memory_repository_product();
        MaterialRepository repo1 = new In_memory_repository_material();
        ImpactStrategyFactory factory = new DefaultImpactStrategyFactory();
        ProductService service = new ProductService(repo, repo1, factory);

        Material fabricA = new Material("Sorona", "Dispose of synthetic textiles in the bin with the 'synthetic textile' label.", Type.SYNTETIC_TEXTILE , 2.0);
        Material fabricB = new Material("Fleece", "Dispose of synthetic textiles in the bin with the 'synthetic textile' label.", Type.SYNTETIC_TEXTILE, 3.0);
        UUID productId = UUID.randomUUID();
        Product product = new Product("Shirt", fabricA, 10, productId);
        repo.save(product);
        product.addMaterial(fabricB);

        ArrayList<Double> materialWeights = new ArrayList<>();
        materialWeights.add(2.0);
        materialWeights.add(2.0);


        //ACT
        ProvideImpactValueResult result = service.calculateImpact(product.getId(), "2", materialWeights); 
        double impactValue = result.getResult();

        //ASSERT
        assertEquals(10.0, impactValue, 0);
    }
}