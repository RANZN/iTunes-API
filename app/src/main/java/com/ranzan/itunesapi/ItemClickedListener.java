package com.ranzan.itunesapi;

public interface ItemClickedListener {
    void onDeleteClicked(ResultsItem resultsItem, int position);

    void onPlayClicked(ResultsItem resultsItem, int position);
}
