package com.example.ekta.assignmentday1.app.data.local;

import com.example.ekta.assignmentday1.app.data.DataSource;

/**
 * Created by ekta on 24/3/17.
 */

public class LocalDataSource implements DataSource {

    @Override
    public void getImage(LoadImageCallback loadImageCallback, String githubName) {
        loadImageCallback.onDataNotAvailable();
    }

    @Override
    public void getRepositoryData(LoadDataCallback loadDataCallback, String githubName) {
        loadDataCallback.onDataNotAvailable();
    }
}
