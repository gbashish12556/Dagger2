package com.simple.dagger.dagger2.screens.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.simple.dagger.dagger2.R;
import com.simple.dagger.dagger2.models.AdapterRepos;
import com.simple.dagger.dagger2.models.GithubRepo;
import com.simple.dagger.dagger2.network.GithubService;
import com.simple.dagger.dagger2.screens.GithubApplication;
import com.simple.dagger.dagger2.screens.GithubApplicationComponent;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.repo_home_list)
    ListView listView;

    @Inject
    GithubService githubService;

    @Inject
    Picasso picasso;

    retrofit2.Call<List<GithubRepo>> reposCall;

    @Inject
    AdapterRepos adapterRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
//        githubService = GithubApplication.get(this).getGithubService();
//        picasso = GithubApplication.get(this).getPicasso();


        HomeActivityComponent component = DaggerHomeActivityComponent.builder().homeActivityModule(new HomeActivityModule(this))
                .githubApplicationComponent(GithubApplication.get(this).getComponent()).build();

        component.injectHomeActivity(this);
//        adapterRepos = component.adapterRepos();

//        listView = findViewById(R.id.repo_home_list);
        listView.setAdapter(adapterRepos);

        reposCall = githubService.getAllRepo();
        reposCall.enqueue(new Callback<List<GithubRepo>>() {

            @Override
            public void onResponse(retrofit2.Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                Log.d("response", String.valueOf(response.body()));
                adapterRepos.swapData(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
