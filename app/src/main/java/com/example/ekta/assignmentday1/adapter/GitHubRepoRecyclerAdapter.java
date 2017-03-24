package com.example.ekta.assignmentday1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ekta.assignmentday1.R;
import com.example.ekta.assignmentday1.networkmodel.GitHubRepo;
import com.example.ekta.assignmentday1.viewholders.GitHubRepoViewHolder;

import java.util.ArrayList;

/**
 * Created by ekta on 24/3/17.
 */

public class GitHubRepoRecyclerAdapter extends RecyclerView.Adapter<GitHubRepoViewHolder> {

    private ArrayList<GitHubRepo> mGitHubRepos;

    public GitHubRepoRecyclerAdapter(ArrayList<GitHubRepo> gitHubRepos) {

        mGitHubRepos = gitHubRepos;
    }

    @Override
    public GitHubRepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new GitHubRepoViewHolder(inflater.inflate(R.layout.github_repo_list_items, parent,
                false));
    }

    @Override
    public void onBindViewHolder(GitHubRepoViewHolder holder, int position) {
        GitHubRepo gitHubRepo = mGitHubRepos.get(position);
        holder.mRepositoryName.setText(gitHubRepo.getName());

    }

    @Override
    public int getItemCount() {
        return mGitHubRepos.size();
    }
}
