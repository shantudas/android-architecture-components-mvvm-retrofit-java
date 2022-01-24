package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.databinding.ListEachRowArticleBinding;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    ArrayList<Article> articleArrayList;

    public ArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        ListEachRowArticleBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_each_row_article, viewGroup, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder viewHolder, int i) {
        Article article = articleArrayList.get(i);
        viewHolder.binding.setArticle(article);
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ListEachRowArticleBinding binding;

        public ViewHolder(ListEachRowArticleBinding binding) {
            super(binding.getRoot());
            this.binding=binding;


        }

        /*public void bind(Article article) {
            tvArticleTitle.setText(article.getTitle());
            if (!TextUtils.isEmpty(article.getDescription())) {
                tvArticleDescription.setText(article.getDescription());
            } else {
                tvArticleDescription.setVisibility(View.GONE);
            }
            tvArticleSourceName.setText(article.getSource().getName());

            try {
                Glide.with(context)
                        .load(article.getUrlToImage())
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(imgViewArticleThumbnail);

            } catch (Exception e) {
                e.printStackTrace();
                imgViewArticleThumbnail.setVisibility(View.GONE);
            }
        }*/
    }
}
