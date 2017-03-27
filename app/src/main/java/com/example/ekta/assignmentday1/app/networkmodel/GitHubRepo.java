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
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("private")
    @Expose
    private Boolean _private;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("description")
    @Expose
    private Object description;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    public Boolean get_private() {
        return _private;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public Object getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "GitHubRepo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", owner=" + owner +
                ", _private=" + _private +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", description=" + description +
                '}';
    }
}
