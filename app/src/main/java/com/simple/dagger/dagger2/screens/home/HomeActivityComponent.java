package com.simple.dagger.dagger2.screens.home;

import com.simple.dagger.dagger2.models.AdapterRepos;
import com.simple.dagger.dagger2.screens.GithubApplicationComponent;

import dagger.Component;

@HomeActivityScope
@Component(modules = HomeActivityModule.class, dependencies = GithubApplicationComponent.class)
public interface HomeActivityComponent {
    void injectHomeActivity(HomeActivity homeActivity);
}
