package com.example.ekta.assignmentday1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatButton button = (AppCompatButton) findViewById(R.id.show_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatEditText editText = (AppCompatEditText) findViewById(R.id.user_name);
                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailIntent.putExtra(Constants.GITHUB_USER_NAME, editText.getText()
                        .toString());
                startActivity(detailIntent);

            }
        });

    }

}
