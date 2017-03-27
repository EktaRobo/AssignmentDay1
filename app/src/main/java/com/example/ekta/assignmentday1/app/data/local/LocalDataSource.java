package com.example.ekta.assignmentday1.app.data.local;

import android.graphics.Bitmap;

import com.bumptech.glide.RequestManager;
import com.example.ekta.assignmentday1.app.background.GetBitmapFromUrl;
import com.example.ekta.assignmentday1.app.data.DataSource;
import com.example.ekta.assignmentday1.app.database.DatabaseHelper;
import com.example.ekta.assignmentday1.app.database.models.GitHubUserRepository;

import java.util.ArrayList;

/**
 * Created by ekta on 24/3/17.
 */

public class LocalDataSource implements DataSource {
    private RequestManager mRequestManager;

    public LocalDataSource(RequestManager requestManager) {
        mRequestManager = requestManager;
    }

    @Override
    public void getImage(final LoadImageCallback loadImageCallback, String gitHubUserName) {

        String avatarUrl = DatabaseHelper.fetchAvatarUrl(gitHubUserName);
        if (avatarUrl != null) {

            GetBitmapFromUrl getBitmapFromUrl = new GetBitmapFromUrl(mRequestManager) {
                @Override
                protected void onPostExecute(Bitmap bitmap) {
                    super.onPostExecute(bitmap);
                    loadImageCallback.onImageLoaded(bitmap);
                }
            };
            getBitmapFromUrl.execute(avatarUrl);
        } else {
            loadImageCallback.onImageNotAvailable();
        }
    }

    @Override
    public void getRepositoryData(LoadDataCallback loadDataCallback, String githubName) {
        ArrayList<GitHubUserRepository> userRepositories = DatabaseHelper.fetchUserRepositoryData
                (githubName);
        if (userRepositories != null) {
            loadDataCallback.onDataLoaded(userRepositories);
        } else {
            loadDataCallback.onDataNotAvailable();
        }
    }
}
