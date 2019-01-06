package com.simple.dagger.dagger2.screens.home;

import android.app.Activity;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.ListView;
import android.widget.Toast;

import com.simple.dagger.dagger2.R;
import com.simple.dagger.dagger2.models.AdapterRepos;
import com.simple.dagger.dagger2.models.GithubRepo;
import com.simple.dagger.dagger2.network.GithubService;
import com.simple.dagger.dagger2.screens.GithubApplication;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends Activity {

    @BindView(R.id.repo_home_list)
    ListView listView;

    GithubService githubService;
    Picasso picasso;

    retrofit2.Call<List<GithubRepo>> reposCall;

    AdapterRepos adapterRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        githubService = GithubApplication.get(this).getGithubService();
        picasso = GithubApplication.get(this).getPicasso();

        adapterRepos = new AdapterRepos(this, picasso);
        listView.setAdapter(adapterRepos);

        reposCall = githubService.getAllRepo();
        reposCall.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(retrofit2.Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                adapterRepos.swapData(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
