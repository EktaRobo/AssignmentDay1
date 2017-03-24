package com.example.ekta.assignmentday1.network;

import android.util.Log;

import com.example.ekta.assignmentday1.OnListFetchListener;
import com.example.ekta.assignmentday1.networkmodel.GitHubRepo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkAdapter {

    private static final String TAG = NetworkAdapter.class.getSimpleName();
    private static NetworkAdapter sInstance = null;
    private ApiInterface mApiService = ApiClient.getClient().create(ApiInterface.class);

    private NetworkAdapter() {
        // Exists only to defeat instantiation.
    }

    public static NetworkAdapter getInstance() {
        if (sInstance == null) {
            sInstance = new NetworkAdapter();
        }
        return sInstance;
    }

    public void getUserData(final OnListFetchListener listener, String githubUserName) {
        Call<ArrayList<GitHubRepo>> call = mApiService.getList(githubUserName);
        call.enqueue(new Callback<ArrayList<GitHubRepo>>() {
            @Override
            public void onResponse(Call<ArrayList<GitHubRepo>> call,
                                   Response<ArrayList<GitHubRepo>> response) {
                ArrayList<GitHubRepo> body = response.body();
                if (body != null) {

                    Log.d(TAG, body.toString());
                } else {
                    Log.d(TAG, response.toString());
                }
                listener.onSuccess(response);
            }

            @Override
            public void onFailure(Call<ArrayList<GitHubRepo>> call, Throwable t) {
                Log.e(TAG, t.toString());
                listener.onFailure(t);
            }
        });
    }
}

