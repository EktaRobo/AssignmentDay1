package com.example.ekta.assignmentday1.app.ui.firstscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import com.example.ekta.assignmentday1.R;
import com.example.ekta.assignmentday1.app.Constants;
import com.example.ekta.assignmentday1.app.ui.detailscreen.DetailActivity;
import com.example.ekta.assignmentday1.dagger.components.DaggerMainScreenComponent;
import com.example.ekta.assignmentday1.dagger.components.MainScreenComponent;
import com.example.ekta.assignmentday1.dagger.modules.MainViewModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Inject
    MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatButton button = (AppCompatButton) findViewById(R.id.show_button);
        MainScreenComponent mainScreenComponent = DaggerMainScreenComponent.builder()
                .mainViewModule(new MainViewModule(this)).build();
        mainScreenComponent.inject(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatEditText editText = (AppCompatEditText) findViewById(R.id.user_name);
                mPresenter.onButtonClicked(editText.getText().toString());
            }
        });

    }

    @Override
    public void navigateToDetailActivity(String githubUsername) {
        Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
        detailIntent.putExtra(Constants.GITHUB_USER_NAME, githubUsername);
        startActivity(detailIntent);
    }
}
