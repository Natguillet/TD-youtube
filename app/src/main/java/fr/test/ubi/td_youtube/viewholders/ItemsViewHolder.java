package fr.test.ubi.td_youtube.viewholders;


import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.test.ubi.td_youtube.R;
import fr.test.ubi.td_youtube.interfaces.OnVideoSelectedListener;
import fr.test.ubi.td_youtube.models.Video;

public class ItemsViewHolder extends RecyclerView.ViewHolder{
    private TextView title;
    private TextView channelTitle;
    private ImageView miniature;
    private OnVideoSelectedListener onVideoSelectedListener;

    public ItemsViewHolder(View itemView) {
        super(itemView);
        miniature = (ImageView) itemView.findViewById(R.id.imageView);
        title = (TextView) itemView.findViewById(R.id.title);
        channelTitle = (TextView) itemView.findViewById(R.id.channelTitle);
    }
    public void bind(final Video video){
        title.setText(video.getSnippet().getTitle());
        channelTitle.setText(video.getSnippet().getChannelTitle());
        Picasso.with(itemView.getContext()).load(video.getSnippet().getThumbnails().getDefaultMiniature().getUrl()).into(miniature);
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                if (onVideoSelectedListener == null){
                    return;
                }
                onVideoSelectedListener.onVideoSelected(video);
            }
        });
    }

    public void setOnVideoSelectedListener(OnVideoSelectedListener onVideoSelectedListener){
        this.onVideoSelectedListener = onVideoSelectedListener;
    }
}
