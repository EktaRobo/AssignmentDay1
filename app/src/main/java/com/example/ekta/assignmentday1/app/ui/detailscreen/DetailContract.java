package com.example.ekta.assignmentday1.app.ui.detailscreen;

import android.graphics.Bitmap;

import com.example.ekta.assignmentday1.app.database.models.GitHubUserRepository;

import java.util.ArrayList;

/**
 * Created by ekta on 27/3/17.
 */

public interface DetailContract {
    interface View {
        void showProgress();

        void hideProgress();

        void displayAvatarImage(Bitmap bitmap);

        void displayUserName(String userName);

        void displayListItems(ArrayList<GitHubUserRepository> gitHubRepos);

    }

    interface Presenter {
        void start(String githubUserName);
    }
}
