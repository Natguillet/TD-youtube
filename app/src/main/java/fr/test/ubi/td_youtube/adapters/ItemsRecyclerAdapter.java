package fr.test.ubi.td_youtube.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import fr.test.ubi.td_youtube.interfaces.OnVideoSelectedListener;
import fr.test.ubi.td_youtube.models.Items;
import fr.test.ubi.td_youtube.viewholders.VideoViewHolder;

public class ItemsRecyclerAdapter extends RecyclerView.Adapter<VideoViewHolder>{
    private final Items items;
    private OnVideoSelectedListener onVideoSelectedListener;

    public ItemsRecyclerAdapter(Items items) {
        this.items = items;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_video, parent, false));
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
