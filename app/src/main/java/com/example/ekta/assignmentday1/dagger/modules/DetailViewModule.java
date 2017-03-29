package com.example.ekta.assignmentday1.dagger.modules;

import com.example.ekta.assignmentday1.app.ui.detailscreen.DetailContract;
import com.example.ekta.assignmentday1.dagger.scopes.DetailScreenScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ekta on 27/3/17.
 */

@Module
public class DetailViewModule {
    DetailContract.RepositoryListView mView;

    public DetailViewModule(DetailContract.RepositoryListView view) {
        mView = view;
    }

    @Provides
    @DetailScreenScope
    public DetailContract.RepositoryListView getView() {
        return mView;
    }
}
