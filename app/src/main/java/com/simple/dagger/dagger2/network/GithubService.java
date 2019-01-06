package com.simple.dagger.dagger2.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

    @GET("users/{username}/respos")
    Call<List<GithubRepo>> getResponseForUser(@Path("username") String username);

    @GET("repositories")
    Call<List<GithubRepo>> getAllRepo();

    @GET("users/{username}")
    Call<GithubUser> getAllRepo();


}
