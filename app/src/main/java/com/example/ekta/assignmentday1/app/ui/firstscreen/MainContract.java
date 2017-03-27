package com.example.ekta.assignmentday1.app.ui.firstscreen;

/**
 * Created by ekta on 27/3/17.
 */

public interface MainContract {

    interface View {
        void navigateToDetailActivity(String githubUsername);

    }

    interface Presenter {
        void onButtonClicked(String githubUsername);
    }
}
