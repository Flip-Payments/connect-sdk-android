package com.flip.connect.data.model.edit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ltorres on 19/07/2017.
 */

public class Patches {
    private List<Patch> patches = new ArrayList<>();

    public void addPatch(String op, String path, String value){
        this.patches.add(new Patch(op, path, value));
    }

    public boolean isNullOrEmpty(){
        return patches.size() <= 0;
    }
}
