package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private Context context;
    ArrayList<Article> articleArrayList;

    public ArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_each_row_article, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder viewHolder, int i) {
        Article article = articleArrayList.get(i);
        viewHolder.bind(article);





        /*viewHolder.tvAuthorAndPublishedAt.setText("-"+article.getAuthor() +" | "+"Published At: "+article.getPublishedAt());
        viewHolder.tvDescription.setText(article.);
        */
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvArticleTitle;
        private final TextView tvArticleDescription;
        private final TextView tvArticleSourceName;
        private final ImageView imgViewArticleThumbnail;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvArticleTitle = itemView.findViewById(R.id.tvArticleTitle);
            tvArticleDescription = itemView.findViewById(R.id.tvArticleDescription);
            tvArticleSourceName = itemView.findViewById(R.id.tvArticleSourceName);
            imgViewArticleThumbnail = itemView.findViewById(R.id.imgViewArticleThumbnail);

        }

        public void bind(Article article) {
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
        }
    }
}
