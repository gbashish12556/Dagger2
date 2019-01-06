package com.simple.dagger.dagger2.screens;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module
public class NetworkModules {

    @Provides
    public OkHttpClient getOkHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache){

        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).cache(cache).build();

    }

    @Provides
    public HttpLoggingInterceptor getLosingInterceptor(){

        Timber.plant(new Timber.DebugTree());

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        return loggingInterceptor;
    }

    @Provides
    public Cache getCache(File cacheFile){
        //NETWORK;
        Cache cache = new Cache(cacheFile, 10*1000*100);
        return cache;
    }

    @Provides
    public File getCahceFile(Context context){

        File cacheFile = new File(context.getCacheDir(),"http_cache");
        cacheFile.mkdir();
        return cacheFile;
    }
}
