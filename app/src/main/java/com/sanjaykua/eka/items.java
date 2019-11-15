package com.sanjaykua.eka;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class items {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("forks")
    @Expose
    private String forks;

    @SerializedName("watchers")
    @Expose
    private String watchers;

    @SerializedName("open_issues")
    @Expose
    private String open_issues;

    @SerializedName("score")
    @Expose
    private String score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getForks() {
        return forks;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }

    public String getWatchers() {
        return watchers;
    }

    public void setWatchers(String watchers) {
        this.watchers = watchers;
    }

    public String getOpen_issues() {
        return open_issues;
    }

    public void setOpen_issues(String open_issues) {
        this.open_issues = open_issues;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
