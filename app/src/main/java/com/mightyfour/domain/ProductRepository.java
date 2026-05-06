package com.mightyfour.domain;
import java.util.List;
import java.util.ArrayList;

public interface ProductRepository {
//Taken from lecture 4
    ArrayList<Product> store = new ArrayList<>();

    void save(Product product);
    List<Product> findAll();

}



