package com.flip.connect.data.dependencies;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jcosilva on 6/8/2017.
 */

public class NetworkDependencies {

    private static OkHttpClient client() {
        return new OkHttpClient.Builder().build();
    }

    public static Retrofit retrofit(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client())
                .build();
    }
}
