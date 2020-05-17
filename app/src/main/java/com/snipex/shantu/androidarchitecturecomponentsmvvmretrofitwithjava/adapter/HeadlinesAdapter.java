package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Headline;

import java.util.ArrayList;
import java.util.List;

public class HeadlinesAdapter extends RecyclerView.Adapter<HeadlinesAdapter.ViewHolder> {
    private Context context;
    private List<Headline> headlineArrayList;

    public HeadlinesAdapter(Context context, List<Headline> headlineArrayList) {
        this.context = context;
        this.headlineArrayList = headlineArrayList;
    }

    @NonNull
    @Override
    public HeadlinesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_each_row_headlines, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadlinesAdapter.ViewHolder holder, int position) {
        Headline headline = headlineArrayList.get(position);
        holder.tvHeadlineTitle.setText(headline.getTitle());
        holder.tvHeadlineDescription.setText(headline.getDescription());
    }

    @Override
    public int getItemCount() {
        return headlineArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvHeadlineTitle;
        private final TextView tvHeadlineDescription;
        private final ImageView imgViewThumbnail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeadlineTitle = itemView.findViewById(R.id.tvHeadlineTitle);
            tvHeadlineDescription = itemView.findViewById(R.id.tvHeadlineDescription);
            imgViewThumbnail = itemView.findViewById(R.id.imgViewThumbnail);
        }
    }
}
