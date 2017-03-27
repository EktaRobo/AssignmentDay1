package com.example.ekta.assignmentday1.dagger.components;

import com.example.ekta.assignmentday1.app.ui.detailscreen.DetailActivity;
import com.example.ekta.assignmentday1.dagger.modules.DetailPresenterModule;
import com.example.ekta.assignmentday1.dagger.scopes.DetailScreenScope;

import dagger.Component;

/**
 * Created by ekta on 27/3/17.
 */

@DetailScreenScope
@Component(dependencies = RepositoryComponent.class, modules = DetailPresenterModule.class)
public interface DetailScreenComponent {
    void inject(DetailActivity detailActivity);
}
