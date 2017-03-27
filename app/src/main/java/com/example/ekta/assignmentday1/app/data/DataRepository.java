package com.example.ekta.assignmentday1.app.data;

import android.graphics.Bitmap;

import com.example.ekta.assignmentday1.app.database.models.GitHubUserRepository;

import java.util.ArrayList;

/**
 * Created by ekta on 24/3/17.
 */

public class DataRepository implements DataSource {

    private DataSource mLocalDataSource, mRemoteDataSource;

    public DataRepository(DataSource localDataSource, DataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void getImage(final LoadImageCallback loadImageCallback) {
        mLocalDataSource.getImage(new LoadImageCallback() {
            @Override
            public void onImageLoaded(Bitmap bitmap) {
                loadImageCallback.onImageLoaded(bitmap);
            }

            @Override
            public void onImageNotAvailable() {
                mRemoteDataSource.getImage(loadImageCallback);
            }
        });
    }

    @Override
    public void getRepositoryData(final LoadDataCallback loadDataCallback, final String
            githubName) {
        mLocalDataSource.getRepositoryData(new LoadDataCallback() {
            @Override
            public void onDataLoaded(ArrayList<GitHubUserRepository> gitHubRepos) {
                loadDataCallback.onDataLoaded(gitHubRepos);
            }

            @Override
            public void onDataNotAvailable() {
                mRemoteDataSource.getRepositoryData(loadDataCallback, githubName);
            }
        }, githubName);
    }
}
