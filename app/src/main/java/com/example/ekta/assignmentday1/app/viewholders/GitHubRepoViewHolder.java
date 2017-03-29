package com.example.ekta.assignmentday1.app.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ekta.assignmentday1.R;

/**
 * Created by ekta on 24/3/17.
 */

public class GitHubRepoViewHolder extends RecyclerView.ViewHolder {
    public TextView mRepositoryName;

    public GitHubRepoViewHolder(View itemView, View.OnClickListener clickListener) {
        super(itemView);
        mRepositoryName = (TextView) itemView.findViewById(R.id.repository_name);
        itemView.setOnClickListener(clickListener);
    }
}
