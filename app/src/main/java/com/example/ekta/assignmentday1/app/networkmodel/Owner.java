package com.example.ekta.assignmentday1.app.networkmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ekta on 24/3/17.
 */

public class Owner {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;


    public Integer getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public String toString() {
        return "Owner{" +
                ", id=" + id +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
