package fr.test.ubi.td_youtube.models;


import com.google.gson.annotations.SerializedName;

public class Thumbnails {
    @SerializedName("default")
    private Miniature defaultMiniature;

    public Miniature getDefaultMiniature() {
        return defaultMiniature;
    }

    public void setDefaultMiniature(Miniature defaultMiniature) {
        this.defaultMiniature = defaultMiniature;
    }
}
