package com.simple.dagger.dagger2.screens.home;

import android.app.Activity;
import android.content.Context;

import com.simple.dagger.dagger2.GithubApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityContextModule {

    private final Context context;

    public ActivityContextModule(Activity activity){

        this.context = activity;
    }

    @Provides
    @GithubApplicationScope
    @Named("activity_context")
    public Context context(){
        return context;
    }
}
