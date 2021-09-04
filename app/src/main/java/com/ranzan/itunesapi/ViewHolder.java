package com.ranzan.itunesapi;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ViewHolder extends RecyclerView.ViewHolder {
    private ImageView trackImage;
    private TextView trackName, trackArtist;
    private ItemClickedListener itemClickedListener;
    private ImageView btnPlay,delete;
    static int n = 0;

    public ViewHolder(@NonNull View itemView, ItemClickedListener itemClickedListener) {
        super(itemView);
        intiViews(itemView);
        this.itemClickedListener = itemClickedListener;
    }

    private void intiViews(View v) {
        trackArtist = v.findViewById(R.id.trackArtist);
        trackImage = v.findViewById(R.id.trackImage);
        trackName = v.findViewById(R.id.trackName);
        delete = v.findViewById(R.id.btnDelete);
        btnPlay = v.findViewById(R.id.btnPlay);
    }

    public void setData(ResultsItem resultsItem) {
        trackName.setText(resultsItem.getTrackName());
        trackArtist.setText(resultsItem.getArtistName());
        Glide.with(itemView).load(resultsItem.getArtworkUrl100()).into(trackImage);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickedListener.onDeleteClicked(resultsItem, getAdapterPosition());
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n == 0) {
                    ++n;
                    btnPlay.setImageResource(R.drawable.pause);
                } else {
                    btnPlay.setImageResource(R.drawable.play);
                    --n;
                }
                itemClickedListener.onPlayClicked(resultsItem, getAdapterPosition());
            }
        });
    }
}
