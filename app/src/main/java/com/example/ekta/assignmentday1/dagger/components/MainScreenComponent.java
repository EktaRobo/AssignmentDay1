package com.example.ekta.assignmentday1.dagger.components;

import com.example.ekta.assignmentday1.app.ui.firstscreen.MainActivity;
import com.example.ekta.assignmentday1.dagger.modules.MainPresenterModule;
import com.example.ekta.assignmentday1.dagger.scopes.MainScreenScope;

import dagger.Component;

/**
 * Created by ekta on 27/3/17.
 */

@MainScreenScope
@Component(modules = MainPresenterModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
