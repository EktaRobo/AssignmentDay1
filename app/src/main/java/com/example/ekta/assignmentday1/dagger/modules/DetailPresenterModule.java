package com.example.ekta.assignmentday1.dagger.modules;

import com.example.ekta.assignmentday1.app.data.DataRepository;
import com.example.ekta.assignmentday1.app.ui.detailscreen.DetailContract;
import com.example.ekta.assignmentday1.app.ui.detailscreen.DetailPresenter;
import com.example.ekta.assignmentday1.dagger.scopes.DetailScreenScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ekta on 27/3/17.
 */

@Module(includes = DetailViewModule.class)
public class DetailPresenterModule {

    @Provides
    @DetailScreenScope
    public DetailContract.Presenter provideDetailScreenPresenter(DetailContract
                                                                             .RepositoryListView
                                                                             view,
                                                                 DataRepository dataRepository) {
        return new DetailPresenter(view, dataRepository);
    }
}
