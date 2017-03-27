package com.example.ekta.assignmentday1.app.ui.firstscreen;

/**
 * Created by ekta on 27/3/17.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Override
    public void onButtonClicked(String githubUsername) {
        if (mView != null) {
            mView.navigateToDetailActivity(githubUsername);
        }
    }
}
