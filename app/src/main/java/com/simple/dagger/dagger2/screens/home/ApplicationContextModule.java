package com.simple.dagger.dagger2.screens.home;

import android.content.Context;

import com.simple.dagger.dagger2.GithubApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {

    private final Context context;

    public ApplicationContextModule(Context context){
        this.context = context;
    }

    @Provides
    @GithubApplicationScope
    @Named("application_context")
    public Context context(){
        return context;
    }
}
