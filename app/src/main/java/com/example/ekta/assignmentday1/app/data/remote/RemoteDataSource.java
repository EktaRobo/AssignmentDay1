package com.example.ekta.assignmentday1.app.data.remote;

import android.graphics.Bitmap;

import com.bumptech.glide.RequestManager;
import com.example.ekta.assignmentday1.app.OnListFetchListener;
import com.example.ekta.assignmentday1.app.data.DataSource;
import com.example.ekta.assignmentday1.app.network.NetworkAdapter;
import com.example.ekta.assignmentday1.app.networkmodel.GitHubRepo;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;

/**
 * Created by ekta on 24/3/17.
 */

public class RemoteDataSource implements DataSource {
    private static String sAvatarUrl;
    private RequestManager mRequestManager;

    public RemoteDataSource(RequestManager requestManager) {
        mRequestManager = requestManager;
    }

    @Override
    public void getImage(LoadImageCallback loadImageCallback, String githubName) {
        try {
            Bitmap theBitmap = mRequestManager.
                    load(sAvatarUrl).
                    asBitmap().
                    into(30, 30). // Width and height
                    get();
            loadImageCallback.onImageLoaded(theBitmap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getRepositoryData(final LoadDataCallback loadDataCallback, String githubName) {
        NetworkAdapter.getInstance().getUserData(new OnListFetchListener() {
            @Override
            public void onSuccess(Response<ArrayList<GitHubRepo>> response) {
                sAvatarUrl = response.body().get(0).getOwner().getAvatarUrl();
                loadDataCallback.onDataLoaded(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                loadDataCallback.onDataNotAvailable();
            }
        }, githubName);
    }
}
