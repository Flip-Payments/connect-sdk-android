package com.flip.connect.data.repository.local;

import android.content.Context;

import com.flip.connect.data.dependencies.TokenType;
import com.flip.connect.domain.model.OauthToken;
import com.flip.connect.domain.repository.LocalRepository;
import com.google.gson.Gson;
import com.jgabrielfreitas.datacontroller.DataController;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class LocalDataManager implements LocalRepository {

    private DataController dataController;

    public LocalDataManager(Context context) {
        this.dataController = new DataController(context);
    }

    @Override
    public void saveOauth(OauthToken token, TokenType tokenType) {
        dataController.writeData(tokenType.toString(), new Gson().toJson(token));
    }

    @Override
    public OauthToken getOauth(TokenType tokenType) {
        return new Gson().fromJson(dataController.readStringData(tokenType.toString()), OauthToken.class);
    }
}
