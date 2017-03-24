package com.example.ekta.assignmentday1.dagger.modules;

import android.content.Context;

import com.example.ekta.assignmentday1.dagger.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * This is a Dagger module. We use this to pass in the Context dependency to the
 * {@link
 * com.example.ekta.assignmentday1}.
 */

@ApplicationScope
@Module
public final class ContextModule {

    private final Context mContext;

    public ContextModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}