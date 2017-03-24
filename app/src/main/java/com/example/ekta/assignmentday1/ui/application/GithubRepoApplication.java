package com.example.ekta.assignmentday1.ui.application;

import android.app.Application;

import com.example.ekta.assignmentday1.dagger.components.DaggerNetworkComponent;
import com.example.ekta.assignmentday1.dagger.components.NetworkComponent;
import com.example.ekta.assignmentday1.dagger.modules.ContextModule;

/**
 * Created by ekta on 24/3/17.
 */

public class GithubRepoApplication extends Application {

    private static NetworkComponent sNetworkComponent;

    public static NetworkComponent getsNetworkComponent() {
        return sNetworkComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sNetworkComponent = DaggerNetworkComponent.builder().contextModule(new ContextModule
                (this)).build();
    }
}
