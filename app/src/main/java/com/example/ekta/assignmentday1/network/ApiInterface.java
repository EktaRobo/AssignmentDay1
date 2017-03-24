package com.example.ekta.assignmentday1.network;


import com.example.ekta.assignmentday1.networkmodel.GitHubRepo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("users/{github_username}/repos")
    Call<ArrayList<GitHubRepo>> getList(@Path("github_username") String githubUserName);
}
