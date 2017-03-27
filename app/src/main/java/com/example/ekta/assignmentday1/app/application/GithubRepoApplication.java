package com.example.ekta.assignmentday1.app.application;

import android.app.Application;

import com.example.ekta.assignmentday1.dagger.components.DaggerNetworkComponent;
import com.example.ekta.assignmentday1.dagger.components.DaggerRepositoryComponent;
import com.example.ekta.assignmentday1.dagger.components.NetworkComponent;
import com.example.ekta.assignmentday1.dagger.components.RepositoryComponent;
import com.example.ekta.assignmentday1.dagger.modules.ContextModule;

/**
 * Created by ekta on 24/3/17.
 */

public class GithubRepoApplication extends Application {

    private static NetworkComponent sNetworkComponent;
    private static RepositoryComponent sRepositoryComponent;

    public static NetworkComponent getsNetworkComponent() {
        return sNetworkComponent;
    }

    public static RepositoryComponent getRepositoryComponent() {
        return sRepositoryComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sNetworkComponent = DaggerNetworkComponent.builder().contextModule(new ContextModule
                (this)).build();
        sRepositoryComponent = DaggerRepositoryComponent.builder().networkComponent
                (sNetworkComponent).build();

    }
}
