package com.example.ekta.assignmentday1.dagger.components;

import com.bumptech.glide.RequestManager;
import com.example.ekta.assignmentday1.app.application.GithubRepoApplication;
import com.example.ekta.assignmentday1.dagger.modules.GlideModule;
import com.example.ekta.assignmentday1.dagger.modules.RetrofitModule;
import com.example.ekta.assignmentday1.dagger.scopes.ApplicationScope;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by ekta on 24/3/17.
 */
@ApplicationScope
@Component(modules = {RetrofitModule.class, GlideModule.class})
public interface NetworkComponent {
    Retrofit provideRetrofit();

    RequestManager provideGlideRequestManager();

    void inject(GithubRepoApplication application);
}
