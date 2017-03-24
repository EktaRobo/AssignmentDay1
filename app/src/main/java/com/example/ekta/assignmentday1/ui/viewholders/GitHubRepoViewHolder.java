package com.example.ekta.assignmentday1.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ekta.assignmentday1.R;

/**
 * Created by ekta on 24/3/17.
 */

public class GitHubRepoViewHolder extends RecyclerView.ViewHolder {
    public ImageView mAvatar;
    public TextView mRepositoryName;

    public GitHubRepoViewHolder(View itemView) {
        super(itemView);
        mAvatar = (ImageView) itemView.findViewById(R.id.avatar);
        mRepositoryName = (TextView) itemView.findViewById(R.id.repository_name);
    }
}
