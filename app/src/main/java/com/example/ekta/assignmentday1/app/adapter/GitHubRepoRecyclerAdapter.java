package com.example.ekta.assignmentday1.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ekta.assignmentday1.R;
import com.example.ekta.assignmentday1.app.database.models.GitHubUserRepository;
import com.example.ekta.assignmentday1.app.viewholders.GitHubRepoViewHolder;

import java.util.ArrayList;

/**
 * Created by ekta on 24/3/17.
 */

public class GitHubRepoRecyclerAdapter extends RecyclerView.Adapter<GitHubRepoViewHolder> {

    private ArrayList<GitHubUserRepository> mGitHubRepos;
    private View.OnClickListener mOnClickListener;

    public GitHubRepoRecyclerAdapter(ArrayList<GitHubUserRepository> gitHubRepos, View
            .OnClickListener onClickListener) {

        mGitHubRepos = gitHubRepos;
        mOnClickListener = onClickListener;
    }

    @Override
    public GitHubRepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new GitHubRepoViewHolder(inflater.inflate(R.layout.github_repo_list_items, parent,
                false), mOnClickListener);
    }

    @Override
    public void onBindViewHolder(GitHubRepoViewHolder holder, int position) {
        GitHubUserRepository gitHubRepo = mGitHubRepos.get(position);
        holder.mRepositoryName.setText(gitHubRepo.getRepositoryName());

    }

    @Override
    public int getItemCount() {
        return mGitHubRepos.size();
    }
}
