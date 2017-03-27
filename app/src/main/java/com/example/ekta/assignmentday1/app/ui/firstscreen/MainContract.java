package com.example.ekta.assignmentday1.app.ui.firstscreen;

import com.example.ekta.assignmentday1.app.BasePresenter;
import com.example.ekta.assignmentday1.app.BaseView;

/**
 * Created by ekta on 27/3/17.
 */

public interface MainContract {

    interface View extends BaseView {
        void navigateToDetailActivity(String githubUsername);

    }

    interface Presenter extends BasePresenter {
        void onButtonClicked(String githubUsername);
    }
}
