package com.simple.dagger.dagger2.screens;

import android.content.Context;

import com.simple.dagger.dagger2.GithubApplicationScope;
import com.simple.dagger.dagger2.screens.home.ApplicationContextModule;

import java.io.File;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes = ApplicationContextModule.class)
public class NetworkModules {

    @Provides
    @GithubApplicationScope
    public OkHttpClient getOkHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache){

        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).cache(cache).build();

    }

    @Provides
    @GithubApplicationScope
    public HttpLoggingInterceptor getLoginInterceptor(){

        Timber.plant(new Timber.DebugTree());

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return loggingInterceptor;
    }

    @Provides
    @GithubApplicationScope
    public Cache getCache(File cacheFile){
        //NETWORK;
        Cache cache = new Cache(cacheFile, 10*1000*100);
        return cache;
    }

    @Provides
    @GithubApplicationScope
    public File getCahceFile(@Named("application_context")  Context context){

        File cacheFile = new File(context.getCacheDir(),"http_cache");
        cacheFile.mkdir();
        return cacheFile;
    }
}
