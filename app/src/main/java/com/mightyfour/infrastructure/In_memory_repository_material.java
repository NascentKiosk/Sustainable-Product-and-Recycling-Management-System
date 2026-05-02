package com.mightyfour.infrastructure;
import java.util.ArrayList;
import java.util.List;

import com.mightyfour.domain.Material;
import com.mightyfour.domain.MaterialRepository;

public class In_memory_repository_material implements MaterialRepository {
     private List<Material> store = new ArrayList<>();


    public void save(Material material){
        store.add(material);
    }

    public List<Material> findAll(){
        return store;
    }

}
