package fr.test.ubi.td_youtube.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.test.ubi.td_youtube.R;
import fr.test.ubi.td_youtube.interfaces.OnVideoSelectedListener;
import fr.test.ubi.td_youtube.models.Items;
import fr.test.ubi.td_youtube.viewholders.ItemsViewHolder;

public class ItemsRecyclerAdapter extends RecyclerView.Adapter<ItemsViewHolder>{
    private final Items items;
    private OnVideoSelectedListener onVideoSelectedListener;

    public ItemsRecyclerAdapter(Items items) {
        this.items = items;
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_video, parent, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {
        holder.setOnVideoSelectedListener(onVideoSelectedListener);
        holder.bind(items.getItems().get(position));
    }

    @Override
    public int getItemCount() {
        return items != null ? items.getItems().size() : 0;
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener) {
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
