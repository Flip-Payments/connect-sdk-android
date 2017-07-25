package com.flip.connect.data.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

/**
 * Created by ltorres on 24/07/2017.
 */

public class UpdateModel {
    private JsonObject body = new JsonObject();

    public void addToBody(String field, Patches patches) {
        body.add(field, new Gson().toJsonTree(patches).getAsJsonObject());
    }

    public JsonObject getBody() {
        return body;
    }
}
