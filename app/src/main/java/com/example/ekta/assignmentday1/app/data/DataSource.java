package com.example.ekta.assignmentday1.app.data;

import android.graphics.Bitmap;

import com.example.ekta.assignmentday1.app.networkmodel.GitHubRepo;

import java.util.ArrayList;

/**
 * Created by ekta on 24/3/17.
 */

public interface DataSource {

    void getImage(LoadImageCallback loadImageCallback);

    void getRepositoryData(LoadDataCallback loadDataCallback, String githubName);

    interface LoadImageCallback {

        void onImageLoaded(Bitmap bitmap);

        void onImageNotAvailable();
    }

    interface LoadDataCallback {

        void onDataLoaded(ArrayList<GitHubRepo> gitHubRepos);

        void onDataNotAvailable();
    }
}
