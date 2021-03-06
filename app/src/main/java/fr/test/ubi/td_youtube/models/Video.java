package fr.test.ubi.td_youtube.models;


import com.google.gson.annotations.SerializedName;

public class Video {
    @SerializedName("snippet")
    private Snippet snippet;
    @SerializedName("id")
    private Id id;

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }
}
