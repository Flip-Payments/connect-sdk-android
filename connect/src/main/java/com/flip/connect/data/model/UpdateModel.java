package com.flip.connect.data.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by ltorres on 24/07/2017.
 */

public class UpdateModel {
    private JsonObject body = new JsonObject();

    public void addToBody(String field, Patches patches) {
        body.add(field, new Gson().toJsonTree(patches).getAsJsonObject());
    }

    public void addToBody(String field, List<Patches> patches, List<String> keys) {
        JsonObject element = new JsonObject();
        for (int i=0;i<keys.size();i++) {
            element.addProperty("key", keys.get(i));
            element.add("patches", new Gson().toJsonTree(patches.get(i)).getAsJsonObject());
        }
        body.add(field, element);
        Log.e("ADD TO BODY", body.toString());
    }

    public JsonObject getBody() {
        return body;
    }
}
