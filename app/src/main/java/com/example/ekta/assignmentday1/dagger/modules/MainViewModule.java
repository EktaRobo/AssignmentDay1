package com.example.ekta.assignmentday1.dagger.modules;

import com.example.ekta.assignmentday1.app.ui.firstscreen.MainContract;
import com.example.ekta.assignmentday1.dagger.scopes.MainScreenScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ekta on 27/3/17.
 */

@Module
public class MainViewModule {
    MainContract.View mView;

    public MainViewModule(MainContract.View view) {
        mView = view;
    }

    @Provides
    @MainScreenScope
    public MainContract.View getView() {
        return mView;
    }
}
