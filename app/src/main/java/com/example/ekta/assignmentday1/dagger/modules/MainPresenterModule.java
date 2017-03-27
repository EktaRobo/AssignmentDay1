package com.example.ekta.assignmentday1.dagger.modules;

import com.example.ekta.assignmentday1.app.ui.firstscreen.MainContract;
import com.example.ekta.assignmentday1.app.ui.firstscreen.MainPresenter;
import com.example.ekta.assignmentday1.dagger.scopes.MainScreenScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ekta on 27/3/17.
 */

@Module(includes = MainViewModule.class)
public class MainPresenterModule {

    @Provides
    @MainScreenScope
    public MainContract.Presenter provideMainScreenPresenter(MainContract.View view) {
        return new MainPresenter(view);
    }
}
