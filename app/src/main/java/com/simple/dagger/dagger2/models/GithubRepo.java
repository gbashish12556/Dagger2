package com.simple.dagger.dagger2.models;

public class GithubRepo {

    String name;
    String starGazerCount;
    String description;
    String openIssueCount;
    String forksCount;
    String updatedAt;
    String avtarUrl;
    long id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarGazerCount() {
        return starGazerCount;
    }

    public void setStarGazerCount(String starGazerCount) {
        this.starGazerCount = starGazerCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpenIssueCount() {
        return openIssueCount;
    }

    public void setOpenIssueCount(String openIssueCount) {
        this.openIssueCount = openIssueCount;
    }

    public String getForksCount() {
        return forksCount;
    }

    public void setForksCount(String forksCount) {
        this.forksCount = forksCount;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAvtarUrl() {
        return avtarUrl;
    }

    public void setAvtarUrl(String avtarUrl) {
        this.avtarUrl = avtarUrl;
    }

}
