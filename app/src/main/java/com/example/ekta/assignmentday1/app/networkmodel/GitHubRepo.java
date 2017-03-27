package com.example.ekta.assignmentday1.app.networkmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ekta on 24/3/17.
 */

public class GitHubRepo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("private")
    @Expose
    private Boolean _private;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public Owner getOwner() {
        return owner;
    }

    public Boolean get_private() {
        return _private;
    }

    @Override
    public String toString() {
        return "GitHubRepo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", _private=" + _private +
                '}';
    }
}
