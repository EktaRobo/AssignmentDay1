package com.example.ekta.assignmentday1.app.ui.detailscreen;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ekta.assignmentday1.R;
import com.example.ekta.assignmentday1.app.Constants;
import com.example.ekta.assignmentday1.app.adapter.GitHubRepoRecyclerAdapter;
import com.example.ekta.assignmentday1.app.application.GithubRepoApplication;
import com.example.ekta.assignmentday1.app.database.models.GitHubUserRepository;
import com.example.ekta.assignmentday1.app.utilities.LoaderDialogUtil;
import com.example.ekta.assignmentday1.dagger.components.DaggerDetailScreenComponent;
import com.example.ekta.assignmentday1.dagger.components.DetailScreenComponent;
import com.example.ekta.assignmentday1.dagger.modules.DetailViewModule;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by ekta on 29/3/17.
 */

public class RepositoryListFragment extends Fragment implements DetailContract
        .RepositoryListView, View.OnClickListener {
    @Inject
    DetailContract.Presenter mPresenter;
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_repository_list, container, false);
        DetailScreenComponent detailScreenComponent = DaggerDetailScreenComponent.builder()
                .detailViewModule(new DetailViewModule(this)).repositoryComponent
                        (GithubRepoApplication.getRepositoryComponent()).build();
        detailScreenComponent.inject(this);
        Bundle data = getArguments();
        if (data != null) {
            String githubName = data.getString(Constants.GITHUB_USER_NAME);
            mPresenter.start(githubName);
        }
        return mRootView;
    }

    @Override
    public void showProgress() {
        LoaderDialogUtil.getInstance().showLoader(getActivity());
    }

    @Override
    public void hideProgress() {
        LoaderDialogUtil.getInstance().dismissLoader(getActivity());
    }

    @Override
    public void displayAvatarImage(final Bitmap bitmap) {
        DetailActivity activity = (DetailActivity) getActivity();
        activity.displayAvatarImage(bitmap);
    }

    @Override
    public void displayUserName(String userName) {
        DetailActivity activity = (DetailActivity) getActivity();
        activity.displayUserName(userName);
    }

    @Override
    public void displayListItems(ArrayList<GitHubUserRepository> gitHubRepos) {
        RecyclerView recyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view);
        GitHubRepoRecyclerAdapter adapter = new GitHubRepoRecyclerAdapter(gitHubRepos, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        TextView textView = (TextView) v.findViewById(R.id.repository_name);
        addNextFragment(textView, false);
        /*String repositoryName = textView.getText().toString();
        RepositoryDetailFragment fragment2 = new RepositoryDetailFragment();
        FragmentManager fragmentManager = getFragmentManager();
        Bundle args = new Bundle();
        args.putString(Constants.REPOSITORY_NAME, repositoryName);
        fragment2.setArguments(args);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.fragment, fragment2);
        fragmentTransaction.commit();*/

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void addNextFragment(TextView textView, boolean overlap) {
        RepositoryDetailFragment sharedElementFragment2 = new RepositoryDetailFragment();
        ViewCompat.setTransitionName(textView, "name");
        Bundle args = new Bundle();
        args.putString(Constants.REPOSITORY_NAME, textView.getText().toString());
        sharedElementFragment2.setArguments(args);

        Slide slideTransition = new Slide(Gravity.RIGHT);
        slideTransition.setDuration(300);

        ChangeBounds changeBoundsTransition = new ChangeBounds();
        changeBoundsTransition.setDuration(500);

        sharedElementFragment2.setEnterTransition(slideTransition);
        sharedElementFragment2.setAllowEnterTransitionOverlap(overlap);
        sharedElementFragment2.setAllowReturnTransitionOverlap(overlap);
        sharedElementFragment2.setSharedElementEnterTransition(changeBoundsTransition);

        getFragmentManager().beginTransaction()
                .replace(R.id.fragment, sharedElementFragment2)
                .addToBackStack(null)
                .addSharedElement(textView, "name")
                .commit();
    }
}
