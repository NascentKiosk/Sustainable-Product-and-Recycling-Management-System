package com.mightyfour.infrastructure;
import java.util.ArrayList;
import java.util.List;

import com.mightyfour.domain.Product;
import com.mightyfour.domain.ProductRepository;

//Taken from lecture 4
public class In_memory_repository_product implements ProductRepository {
    private List<Product> store = new ArrayList<>();


    public void save(Product product){
        store.add(product);
    }

    public List<Product> findAll(){
        return store;
    }

   
}