package com.simple.dagger.dagger2.models;

import android.content.Context;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.simple.dagger.dagger2.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoListItem extends FrameLayout {

    private Picasso picasso;

    @BindView(R.id.user_avatar)
    ImageView userAvtar;

    @BindView(R.id.repo_name)
    TextView repoName;

    @BindView(R.id.repo_description)
    TextView repoDescription;

    @BindView(R.id.repo_stars)
    TextView repoStars;

    @BindView(R.id.repo_issues)
    TextView repoIssues;

    @BindView(R.id.repo_forks)
    TextView repoForks;

    @BindView(R.id.repo_updated_at)
    TextView repoUpdatedAt;


    public RepoListItem(Context context, Picasso picasso) {
        super(context);
        this.picasso = picasso;
        inflate(getContext(), R.layout.list_tem_repo, this);
        ButterKnife.bind(this);
    }

    public void setRepo(GithubRepo githubRepo){
        repoName.setText(githubRepo.name);
        repoStars.setText(githubRepo.starGazerCount);
        repoDescription.setText(githubRepo.description);
        repoIssues.setText(githubRepo.openIssueCount);
        repoForks.setText(githubRepo.forksCount);
        repoUpdatedAt.setText(githubRepo.updatedAt);
        picasso.load(githubRepo.avtarUrl).into(userAvtar);

    }

}
