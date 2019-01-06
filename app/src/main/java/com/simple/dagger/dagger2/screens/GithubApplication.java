package com.simple.dagger.dagger2.screens;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.simple.dagger.dagger2.network.GithubService;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class GithubApplication extends Application {


    private GithubService githubService;
    private Picasso picasso;

    public static GithubApplication get(Activity activity){
        return (GithubApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();



        //CONTEXT
        Context context = this;


    }

    public GithubService getGithubService(){
        return githubService;
    }

    public Picasso getPicasso(){
        return picasso;
    }

}