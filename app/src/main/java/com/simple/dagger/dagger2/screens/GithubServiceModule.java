package com.simple.dagger.dagger2.screens;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.simple.dagger.dagger2.GithubApplicationScope;
import com.simple.dagger.dagger2.network.GithubService;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module(includes = NetworkModules.class)
public class GithubServiceModule {

    @Provides
    @GithubApplicationScope
    public GithubService getGithubService(Retrofit githubRetrofit){

        return  githubRetrofit.create(GithubService.class);
    }

    @Provides
    @GithubApplicationScope
    public Retrofit getRetrofit(Gson gson, OkHttpClient okHttpClient){
        return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient)
                .baseUrl("https://api.github.com/").build();
    }


    @Provides
    @GithubApplicationScope
    public Gson getGson(){
        //CLIENT
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson =  gsonBuilder.create();
        return gson;

    }


}
