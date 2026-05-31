package com.mightyfour.application;
import java.util.UUID;
import java.util.HashMap;

public class ListProductsResult{
    private HashMap<UUID, String> productNamesAndUUIDs;

    public ListProductsResult(HashMap<UUID, String> productNamesAndUUIDs){
        this.productNamesAndUUIDs = productNamesAndUUIDs;
    }


    public HashMap<UUID, String> getProductNamesAndUUIDs(){

        return productNamesAndUUIDs;
    }
}