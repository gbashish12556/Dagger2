package com.simple.dagger.dagger2.screens;

import com.simple.dagger.dagger2.GithubApplicationScope;
import com.simple.dagger.dagger2.network.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class })
public interface GithubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();

}
