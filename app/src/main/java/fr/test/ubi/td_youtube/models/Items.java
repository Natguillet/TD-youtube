package fr.test.ubi.td_youtube.models;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Items{
    @SerializedName("items")
    private List<Video> items;

    public List<Video> getItems() {
        return items;
    }

    public void setItems(List<Video> items) {
        this.items = items;
    }
}
