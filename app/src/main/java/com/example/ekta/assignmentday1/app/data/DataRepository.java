package com.example.ekta.assignmentday1.app.data;

import android.graphics.Bitmap;

import com.example.ekta.assignmentday1.app.networkmodel.GitHubRepo;

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
    public void getImage(final LoadImageCallback loadImageCallback, final String githubName) {
        mLocalDataSource.getImage(new LoadImageCallback() {
            @Override
            public void onImageLoaded(Bitmap bitmap) {
                loadImageCallback.onImageLoaded(bitmap);
            }

            @Override
            public void onDataNotAvailable() {
                mRemoteDataSource.getImage(loadImageCallback, githubName);
            }
        }, githubName);
    }

    @Override
    public void getRepositoryData(final LoadDataCallback loadDataCallback, final String
            githubName) {
        mLocalDataSource.getRepositoryData(new LoadDataCallback() {
            @Override
            public void onDataLoaded(ArrayList<GitHubRepo> gitHubRepos) {
                loadDataCallback.onDataLoaded(gitHubRepos);
            }

            @Override
            public void onDataNotAvailable() {
                mRemoteDataSource.getRepositoryData(loadDataCallback, githubName);
            }
        }, githubName);
    }
}
