package com.example.ekta.assignmentday1.dagger.components;

import com.example.ekta.assignmentday1.app.data.DataRepository;
import com.example.ekta.assignmentday1.dagger.modules.RepositoryModule;
import com.example.ekta.assignmentday1.dagger.scopes.RepositoryScope;

import dagger.Component;

/**
 * Created by ekta on 24/3/17.
 */

@RepositoryScope
@Component(dependencies = NetworkComponent.class, modules = RepositoryModule.class)
public interface RepositoryComponent {
    DataRepository provideDataRepository();
}
