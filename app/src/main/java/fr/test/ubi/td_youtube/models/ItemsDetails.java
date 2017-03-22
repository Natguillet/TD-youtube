package fr.test.ubi.td_youtube.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemsDetails {
    @SerializedName("items")
    private List<Detail> items;

    public List<Detail> getItems() {
        return items;
    }

    public void setItems(List<Detail> items) {
        this.items = items;
    }
}
