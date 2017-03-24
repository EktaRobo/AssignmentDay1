package com.example.ekta.assignmentday1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ekta.assignmentday1.R;
import com.example.ekta.assignmentday1.ui.adapter.GitHubRepoRecyclerAdapter;
import com.example.ekta.assignmentday1.ui.network.NetworkAdapter;
import com.example.ekta.assignmentday1.ui.networkmodel.GitHubRepo;

import java.util.ArrayList;

import retrofit2.Response;

public class DetailActivity extends AppCompatActivity implements OnListFetchListener {

    private static final String TAG = DetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent data = getIntent();
        if (data != null) {
            String githubName = data.getStringExtra(Constants.GITHUB_USER_NAME);
            NetworkAdapter.getInstance().getUserData(DetailActivity.this, githubName);
        }
    }


    @Override
    public void onSuccess(Response<ArrayList<GitHubRepo>> response) {
        Log.e(TAG, "onSuccess: " + response.body().toString());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GitHubRepoRecyclerAdapter adapter = new GitHubRepoRecyclerAdapter(response.body());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onFailure(Throwable t) {
        Log.e(TAG, "onFailure: " + t.getMessage());
    }
}
