package com.example.ekta.assignmentday1.app.ui.detailscreen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ekta.assignmentday1.R;
import com.example.ekta.assignmentday1.app.Constants;
import com.example.ekta.assignmentday1.app.ui.BaseActivity;
import com.example.ekta.assignmentday1.app.utilities.ActivityUtils;

import javax.inject.Inject;

public class DetailActivity extends BaseActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();
    @Inject
    DetailContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        RepositoryListFragment repositoryListFragment = new RepositoryListFragment();
        Intent data = getIntent();
        if (data != null) {
            String githubName = data.getStringExtra(Constants.GITHUB_USER_NAME);
            Bundle args = new Bundle();
            args.putString(Constants.GITHUB_USER_NAME, githubName);
            repositoryListFragment.setArguments(args);
        }
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), repositoryListFragment,
                R.id.fragment);
    }


    public void displayAvatarImage(final Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        ImageView imageView = (ImageView) findViewById(R.id.avatar);
        imageView.setImageBitmap(bitmap);
    }


    public void displayUserName(String userName) {
        TextView textView = (TextView) findViewById(R.id.user_name);
        textView.setText(userName);
    }

}
