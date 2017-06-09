package com.flip.connect.data.dependencies;

import com.flip.connect.BuildConfig;

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

    public static Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client())
                .build();
    }
}
