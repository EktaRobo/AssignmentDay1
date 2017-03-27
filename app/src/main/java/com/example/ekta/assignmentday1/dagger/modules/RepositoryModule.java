package com.example.ekta.assignmentday1.dagger.modules;

import com.bumptech.glide.RequestManager;
import com.example.ekta.assignmentday1.app.data.DataRepository;
import com.example.ekta.assignmentday1.app.data.DataSource;
import com.example.ekta.assignmentday1.app.data.local.LocalDataSource;
import com.example.ekta.assignmentday1.app.data.remote.RemoteDataSource;
import com.example.ekta.assignmentday1.dagger.scopes.Local;
import com.example.ekta.assignmentday1.dagger.scopes.Remote;
import com.example.ekta.assignmentday1.dagger.scopes.RepositoryScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ekta on 24/3/17.
 */

@Module
public class RepositoryModule {

    @Provides
    @RepositoryScope
    public DataRepository provideDataRepository(@Local DataSource localDataSource, @Remote
            DataSource remoteDataSource) {
        return new DataRepository(localDataSource, remoteDataSource);
    }

    @Provides
    @RepositoryScope
    @Local
    public DataSource provideLocalDataSource() {
        return new LocalDataSource();
    }

    @Provides
    @RepositoryScope
    @Remote
    public DataSource provideRemoteDataSource(RequestManager requestManager) {
        return new RemoteDataSource(requestManager);
    }
}
