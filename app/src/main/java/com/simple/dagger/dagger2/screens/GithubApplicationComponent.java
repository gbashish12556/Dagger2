package com.simple.dagger.dagger2.screens;

import com.simple.dagger.dagger2.network.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

@Component(modules = GithubServiceModule.class)
public interface GithubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();

}
