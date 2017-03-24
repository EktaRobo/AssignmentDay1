package com.example.ekta.assignmentday1.dagger.components;

import com.bumptech.glide.RequestManager;
import com.example.ekta.assignmentday1.dagger.ApplicationScope;
import com.example.ekta.assignmentday1.dagger.modules.GlideModule;
import com.example.ekta.assignmentday1.dagger.modules.RetrofitModule;
import com.example.ekta.assignmentday1.ui.application.GithubRepoApplication;

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
