package com.flip.connect.data.model;

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

    private class Patch{

        public Patch(String op, String path, String value){
            this.op = op;
            this.path = path;
            this.value = value;
        }

        private String op, path, value;

        public String getOp() {
            return op;
        }

        public void setOp(String op) {
            this.op = op;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
