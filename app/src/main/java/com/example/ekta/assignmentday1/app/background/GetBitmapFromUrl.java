package com.example.ekta.assignmentday1.app.background;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import com.bumptech.glide.RequestManager;

import java.util.concurrent.ExecutionException;

/**
 * Created by ekta on 27/3/17.
 */

public class GetBitmapFromUrl extends AsyncTask<String, Void, Bitmap> {
    private static final String TAG = GetBitmapFromUrl.class.getSimpleName();
    private RequestManager mRequestManager;

    public GetBitmapFromUrl(RequestManager requestManager) {
        mRequestManager = requestManager;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Log.e(TAG, "getImage: avatar URL " + params[0]);

        Bitmap theBitmap = null;
        try {
            if (params[0] == null) {
                return null;
            }
            theBitmap = mRequestManager.
                    load(params[0]).
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

}
