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
}
