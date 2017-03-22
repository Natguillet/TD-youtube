package fr.test.ubi.td_youtube.models;


import android.provider.MediaStore;

import com.google.gson.annotations.SerializedName;

public class Snippet {
    @SerializedName("publishedAt")
    private String publishedAt;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("thumbnails")
    private Thumbnails thumbnails;
    @SerializedName("channelTitle")
    private String channelTitle;

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }
}
