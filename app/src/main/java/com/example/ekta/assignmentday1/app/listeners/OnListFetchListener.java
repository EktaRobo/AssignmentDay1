package com.example.ekta.assignmentday1.app.listeners;

import com.example.ekta.assignmentday1.app.networkmodel.GitHubRepo;

import java.util.ArrayList;

import retrofit2.Response;

/**
 * Created by ekta on 12/12/16.
 */
public interface OnListFetchListener {
    void onSuccess(Response<ArrayList<GitHubRepo>> response);

    void onFailure(Throwable t);
}
