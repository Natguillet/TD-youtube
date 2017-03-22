package fr.test.ubi.td_youtube.models;

import com.google.gson.annotations.SerializedName;

public class Miniature {
    @SerializedName("url")
    private String url;
    @SerializedName("width")
    private int width;
    @SerializedName("height")
    private int height;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
