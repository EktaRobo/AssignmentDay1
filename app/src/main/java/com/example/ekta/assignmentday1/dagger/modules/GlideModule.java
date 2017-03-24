package com.example.ekta.assignmentday1.dagger.modules;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.ekta.assignmentday1.dagger.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ekta on 24/3/17.
 */
@ApplicationScope
@Module(includes = ContextModule.class)
public class GlideModule {
    @Provides
    @ApplicationScope
    public RequestManager provideRequestManager(Context context) {
        return Glide.with(context);
    }

}
