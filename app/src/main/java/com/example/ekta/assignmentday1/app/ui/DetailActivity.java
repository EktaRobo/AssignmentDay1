package com.example.ekta.assignmentday1.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ekta.assignmentday1.R;
import com.example.ekta.assignmentday1.app.Constants;
import com.example.ekta.assignmentday1.app.adapter.GitHubRepoRecyclerAdapter;
import com.example.ekta.assignmentday1.app.application.GithubRepoApplication;
import com.example.ekta.assignmentday1.app.data.DataRepository;
import com.example.ekta.assignmentday1.app.data.DataSource;
import com.example.ekta.assignmentday1.app.networkmodel.GitHubRepo;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();
    private DataRepository mDataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mDataRepository = GithubRepoApplication.getRepositoryComponent()
                .provideDataRepository();
        Intent data = getIntent();
        if (data != null) {
            String githubName = data.getStringExtra(Constants.GITHUB_USER_NAME);
            mDataRepository.getRepositoryData(new DataSource.LoadDataCallback() {
                @Override
                public void onDataLoaded(ArrayList<GitHubRepo> gitHubRepos) {
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    GitHubRepoRecyclerAdapter adapter = new GitHubRepoRecyclerAdapter(gitHubRepos);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(DetailActivity
                            .this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onDataNotAvailable() {
                    Log.e(TAG, "onFailure: Data unavailable");
                }
            }, githubName);

        }
    }


//    @Override
//    public void onSuccess(Response<ArrayList<GitHubRepo>> response) {
//        Log.e(TAG, "onSuccess: " + response.body().toString());
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        GitHubRepoRecyclerAdapter adapter = new GitHubRepoRecyclerAdapter(response.body());
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//
//    }
//
//    @Override
//    public void onFailure(Throwable t) {
//        Log.e(TAG, "onFailure: " + t.getMessage());
//    }
}
