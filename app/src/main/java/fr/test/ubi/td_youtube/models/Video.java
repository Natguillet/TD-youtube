package fr.test.ubi.td_youtube.models;


import com.google.gson.annotations.SerializedName;

public class Video {
    @SerializedName("snippet")
    private Snippet snippet;

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }
}
