package com.simple.dagger.dagger2.models;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdapterRepos extends BaseAdapter {

    private Context context;
    private Picasso picasso;
    private List<GithubRepo> repoList = new ArrayList<>();


    public AdapterRepos(Context context, Picasso picasso){
        this.context = context;
        this.picasso = picasso;
    }

    @Override
    public int getCount() {
        return repoList.size();
    }

    @Override
    public GithubRepo getItem(int position) {
        return repoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return repoList.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RepoListItem repoListItem;
        if(convertView == null){
            repoListItem  = new RepoListItem(context,picasso);
        }else{
            repoListItem   = RepoListItem.class.cast(convertView);
        }
        repoListItem.setRepo(repoList.get(position));
        return repoListItem;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    public void swapData(Collection<GithubRepo> githubRepos){

        repoList.clear();
        if(githubRepos != null){
            repoList.addAll(githubRepos);
        }
        notifyDataSetChanged();
    }
}
