package com.simple.dagger.dagger2.screens;

import android.content.Context;

import com.simple.dagger.dagger2.GithubApplicationScope;
import com.simple.dagger.dagger2.screens.home.ApplicationContextModule;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes = {ApplicationContextModule.class,NetworkModules.class})
public class PicassoModule {

    @Provides
    @GithubApplicationScope
    public Picasso getPicassp(OkHttp3Downloader okHttp3Downloader, @Named("application_context") Context context){
        return new Picasso.Builder(context).downloader(okHttp3Downloader).build();
    }

    @Provides
    @GithubApplicationScope
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }
}
