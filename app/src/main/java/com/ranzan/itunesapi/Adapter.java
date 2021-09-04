package com.ranzan.itunesapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private List<ResultsItem> itemList;
    private ItemClickedListener itemClickedListener;

    public Adapter(List<ResultsItem> itemList, ItemClickedListener itemClickedListener) {
        this.itemList = itemList;
        this.itemClickedListener = itemClickedListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view,itemClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResultsItem resultsItem = itemList.get(position);
        holder.setData(resultsItem);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    void updateDataList(List<ResultsItem> resultsItems) {
        itemList = resultsItems;
        notifyDataSetChanged();
    }
}
