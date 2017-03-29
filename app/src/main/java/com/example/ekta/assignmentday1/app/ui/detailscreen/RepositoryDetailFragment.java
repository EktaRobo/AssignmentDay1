package com.example.ekta.assignmentday1.app.ui.detailscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ekta.assignmentday1.R;
import com.example.ekta.assignmentday1.app.Constants;

/**
 * Created by ekta on 29/3/17.
 */

public class RepositoryDetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repository_detail, container, false);
        Bundle data = getArguments();
        if (data != null) {
            String githubName = data.getString(Constants.REPOSITORY_NAME);
            ((TextView) view.findViewById(R.id.repository_name)).setText(githubName);
        }
        return view;
    }
}
