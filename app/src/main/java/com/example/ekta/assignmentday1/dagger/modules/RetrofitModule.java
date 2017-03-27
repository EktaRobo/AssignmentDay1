package com.example.ekta.assignmentday1.dagger.modules;

import com.example.ekta.assignmentday1.app.Constants;
import com.example.ekta.assignmentday1.dagger.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ekta on 24/3/17.
 */

@Module
public class RetrofitModule {

    @Provides
    @ApplicationScope
    public Retrofit provideRetrofitObject(OkHttpClient.Builder okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build();
    }

    @Provides
    @ApplicationScope
    public OkHttpClient.Builder provideOkHttpClient(HttpLoggingInterceptor logging) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add mLogging as last interceptor
        httpClient.addInterceptor(logging);
        return httpClient;
    }

    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }
}
