package com.example.ekta.assignmentday1.app.data.remote;

import android.graphics.Bitmap;

import com.bumptech.glide.RequestManager;
import com.example.ekta.assignmentday1.app.OnListFetchListener;
import com.example.ekta.assignmentday1.app.background.GetBitmapFromUrl;
import com.example.ekta.assignmentday1.app.data.DataSource;
import com.example.ekta.assignmentday1.app.database.DatabaseHelper;
import com.example.ekta.assignmentday1.app.database.models.GitHubUserRepository;
import com.example.ekta.assignmentday1.app.network.NetworkAdapter;
import com.example.ekta.assignmentday1.app.networkmodel.GitHubRepo;

import java.util.ArrayList;

import retrofit2.Response;

/**
 * Created by ekta on 24/3/17.
 */

public class RemoteDataSource implements DataSource {
    private static final String TAG = RemoteDataSource.class.getSimpleName();
    private RequestManager mRequestManager;

    public RemoteDataSource(RequestManager requestManager) {
        mRequestManager = requestManager;
    }

    @Override
    public void getImage(final LoadImageCallback loadImageCallback) {
        String avatarUrl = null;
        GetBitmapFromUrl getBitmapFromUrl = new GetBitmapFromUrl(mRequestManager) {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                loadImageCallback.onImageLoaded(bitmap);
            }
        };
        getBitmapFromUrl.execute(avatarUrl);
        /*Log.e(TAG, "getImage: avatar URL " + sAvatarUrl);
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {
                Bitmap theBitmap = null;
                try {
                    theBitmap = mRequestManager.
                            load(sAvatarUrl).
                            asBitmap().
                            into(30, 30). // Width and height
                            get();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                return theBitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                loadImageCallback.onImageLoaded(bitmap);

            }
        }.execute();*/

    }

    @Override
    public void getRepositoryData(final LoadDataCallback loadDataCallback, final String
            githubName) {
        NetworkAdapter.getInstance().getUserData(new OnListFetchListener() {
            @Override
            public void onSuccess(Response<ArrayList<GitHubRepo>> response) {

                ArrayList<GitHubRepo> gitHubRepos = response.body();
                ArrayList<GitHubUserRepository> gitHubUserRepositories = new ArrayList
                        <>();
                for (GitHubRepo gitHubRepo : gitHubRepos) {
                    GitHubUserRepository gitHubUserRepository = new GitHubUserRepository();
                    gitHubUserRepository.setIsPrivate(gitHubRepo.get_private());
                    gitHubUserRepository.setRepositoryName(gitHubRepo.getName());
                    gitHubUserRepositories.add(gitHubUserRepository);

                }

                DatabaseHelper.addToDatabase(gitHubRepos, githubName, gitHubUserRepositories);
                loadDataCallback.onDataLoaded(gitHubUserRepositories);
            }

            @Override
            public void onFailure(Throwable t) {
                loadDataCallback.onDataNotAvailable();
            }
        }, githubName);
    }
}
