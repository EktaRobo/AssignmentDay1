package com.example.ekta.assignmentday1.app.database;

import com.example.ekta.assignmentday1.app.database.models.GitHubUser;
import com.example.ekta.assignmentday1.app.database.models.GitHubUserRepository;
import com.example.ekta.assignmentday1.app.networkmodel.GitHubRepo;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by ekta on 27/3/17.
 */

public class DatabaseHelper {

    /**
     * Adds user repository data to database
     *
     * @param gitHubRepos
     * @param githubName
     * @param gitHubUserRepositories
     */
    public static void addToDatabase(final ArrayList<GitHubRepo> gitHubRepos, final String
            githubName, final ArrayList<GitHubUserRepository> gitHubUserRepositories) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                GitHubUser gitHubUser = new GitHubUser();
                gitHubUser.setGitHubUserName(githubName);
                gitHubUser.setAvatarUrl(gitHubRepos.get(0).getOwner().getAvatarUrl());
                ArrayList<GitHubUserRepository> gitHubUserRepositoryListForDb = new ArrayList<>();
                for (GitHubUserRepository gitHubUserRepository : gitHubUserRepositories) {
                    GitHubUserRepository gitHubRepositoryForDb = realm.copyToRealm
                            (gitHubUserRepository);
                    gitHubUserRepositoryListForDb.add(gitHubRepositoryForDb);
                }

                gitHubUser.setGitHubUserRepositories(new RealmList<>(gitHubUserRepositoryListForDb
                        .toArray(new GitHubUserRepository[gitHubUserRepositoryListForDb.size()])));
                realm.copyToRealmOrUpdate(gitHubUser);
            }
        });
    }


}
