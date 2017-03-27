package com.example.ekta.assignmentday1.app.database.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by ekta on 27/3/17.
 */

public class GitHubUser extends RealmObject {

    @PrimaryKey
    @Required
    private String mGitHubUserName;
    private String mAvatarUrl;
    private RealmList<GitHubUserRepository> mGitHubUserRepositories;

    public String getGitHubUserName() {
        return mGitHubUserName;
    }

    public void setGitHubUserName(String gitHubUserName) {
        mGitHubUserName = gitHubUserName;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public RealmList<GitHubUserRepository> getGitHubUserRepositories() {
        return mGitHubUserRepositories;
    }

    public void setGitHubUserRepositories(RealmList<GitHubUserRepository> gitHubUserRepositories) {
        mGitHubUserRepositories = gitHubUserRepositories;
    }
}
