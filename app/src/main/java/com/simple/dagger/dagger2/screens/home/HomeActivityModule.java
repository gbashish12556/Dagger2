package com.simple.dagger.dagger2.screens.home;

import com.simple.dagger.dagger2.models.AdapterRepos;
import com.simple.dagger.dagger2.screens.PicassoModule;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeActivityModule {

    public final HomeActivity homeActivity;

    public HomeActivityModule(HomeActivity homeActivity){
        this.homeActivity = homeActivity;
    }

    @HomeActivityScope
    @Provides
    public HomeActivity homeActivity(){
        return homeActivity;
    }

}
