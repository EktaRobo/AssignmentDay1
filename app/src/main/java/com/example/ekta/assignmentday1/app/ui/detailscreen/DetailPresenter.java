package com.example.ekta.assignmentday1.app.ui.detailscreen;

import android.graphics.Bitmap;

import com.example.ekta.assignmentday1.app.data.DataRepository;
import com.example.ekta.assignmentday1.app.data.DataSource;
import com.example.ekta.assignmentday1.app.database.models.GitHubUserRepository;

import java.util.ArrayList;

/**
 * Created by ekta on 27/3/17.
 */

public class DetailPresenter implements DetailContract.Presenter, DataSource.LoadDataCallback,
        DataSource.LoadImageCallback {
    private DetailContract.View mView;
    private DataRepository mDataRepository;
    private String mGithubUserName;

    public DetailPresenter(DetailContract.View view, DataRepository dataRepository) {
        mView = view;
        mDataRepository = dataRepository;
    }

    @Override
    public void start(final String githubUserName) {
        mGithubUserName = githubUserName;
        if (mDataRepository != null && mView != null) {
            mView.displayUserName(githubUserName);
            mView.showProgress();
            mDataRepository.getRepositoryData(this, githubUserName);
        }
    }

    @Override
    public void onDataLoaded(ArrayList<GitHubUserRepository> gitHubRepos) {
        if (mView != null) {
            mView.hideProgress();
            mDataRepository.getImage(DetailPresenter.this, mGithubUserName);
            mView.displayListItems(gitHubRepos);
        }
    }

    @Override
    public void onDataNotAvailable() {
        if (mView != null) {
            mView.hideProgress();
        }

    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        if (mView != null) {
            mView.hideProgress();
            mView.displayAvatarImage(bitmap);
        }
    }

    @Override
    public void onImageNotAvailable() {
        if (mView != null) {
            mView.hideProgress();
        }
    }
}
