package com.flip.connect.data.model.edit;

/**
 * Created by ltorres on 28/07/2017.
 */

class Patch{

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