package com.example.ekta.assignmentday1.app.ui.detailscreen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ekta.assignmentday1.R;
import com.example.ekta.assignmentday1.app.Constants;
import com.example.ekta.assignmentday1.app.adapter.GitHubRepoRecyclerAdapter;
import com.example.ekta.assignmentday1.app.application.GithubRepoApplication;
import com.example.ekta.assignmentday1.app.networkmodel.GitHubRepo;
import com.example.ekta.assignmentday1.app.utilities.LoaderDialogUtil;
import com.example.ekta.assignmentday1.dagger.components.DaggerDetailScreenComponent;
import com.example.ekta.assignmentday1.dagger.components.DetailScreenComponent;
import com.example.ekta.assignmentday1.dagger.modules.DetailViewModule;

import java.util.ArrayList;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    private static final String TAG = DetailActivity.class.getSimpleName();
    @Inject
    DetailContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        DetailScreenComponent detailScreenComponent = DaggerDetailScreenComponent.builder()
                .detailViewModule(new DetailViewModule(this)).repositoryComponent
                        (GithubRepoApplication.getRepositoryComponent()).build();
        detailScreenComponent.inject(this);
        Intent data = getIntent();
        if (data != null) {
            String githubName = data.getStringExtra(Constants.GITHUB_USER_NAME);
            mPresenter.start(githubName);
        }
        /*mDataRepository = GithubRepoApplication.getRepositoryComponent()
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

        }*/
    }

    @Override
    public void showProgress() {
        LoaderDialogUtil.getInstance().showLoader(DetailActivity.this);
    }

    @Override
    public void hideProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LoaderDialogUtil.getInstance().dismissLoader(DetailActivity.this);
            }
        });

    }

    @Override
    public void displayAvatarImage(final Bitmap bitmap) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ImageView imageView = (ImageView) findViewById(R.id.avatar);
                imageView.setImageBitmap(bitmap);
            }
        });

    }

    @Override
    public void displayUserName(String userName) {
        TextView textView = (TextView) findViewById(R.id.user_name);
        textView.setText(userName);
    }

    @Override
    public void displayListItems(ArrayList<GitHubRepo> gitHubRepos) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GitHubRepoRecyclerAdapter adapter = new GitHubRepoRecyclerAdapter(gitHubRepos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(DetailActivity
                .this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
