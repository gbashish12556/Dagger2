package com.simple.dagger.dagger2.screens;

import android.app.Activity;
import android.app.Application;
import com.simple.dagger.dagger2.network.GithubService;
import com.simple.dagger.dagger2.screens.home.ApplicationContextModule;
import com.squareup.picasso.Picasso;

public class GithubApplication extends Application {


    private GithubService githubService;
    private Picasso picasso;
    private GithubApplicationComponent component;

    public static GithubApplication get(Activity activity){
        return (GithubApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerGithubApplicationComponent.builder()
                .applicationContextModule(new ApplicationContextModule(this)).build();

        githubService = component.getGithubService();
        picasso = component.getPicasso();

        GithubService githubService1 = component.getGithubService();
        Picasso picasso1 = component.getPicasso();

        GithubService githubService2 = component.getGithubService();
        Picasso picasso2 = component.getPicasso();


    }

    public GithubApplicationComponent getComponent(){
        return component;
    }

    public GithubService getGithubService(){
        return githubService;
    }

    public Picasso getPicasso(){
        return picasso;
    }

}