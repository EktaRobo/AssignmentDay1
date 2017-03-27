package com.example.ekta.assignmentday1.app.database.models;

import io.realm.RealmObject;

/**
 * Created by ekta on 27/3/17.
 */

public class GitHubUserRepository extends RealmObject {
    private String mRepositoryName;
    private Boolean mIsPrivate;

    public String getRepositoryName() {
        return mRepositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        mRepositoryName = repositoryName;
    }

    public Boolean getIsPrivate() {
        return mIsPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        mIsPrivate = isPrivate;
    }
}
