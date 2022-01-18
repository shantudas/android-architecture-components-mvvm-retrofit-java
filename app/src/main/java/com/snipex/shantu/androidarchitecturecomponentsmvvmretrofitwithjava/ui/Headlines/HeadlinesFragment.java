package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.ui.Headlines;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter.HeadlinesAdapter;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter.ArticleAdapter;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.ArticleResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.HeadlinesResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view_model.ArticleViewModel;


import java.util.ArrayList;

/*
 * Resources :: for help to create this project
 *
 * Source-1             ::  https://medium.com/@amtechnovation/android-architecture-component-mvvm-part-1-a2e7cff07a76
 * source description   ::  for MVVM pattern using  live data and view model by help of retrofit
 *
 * Source -2            ::  https://proandroiddev.com/8-steps-to-implement-paging-library-in-android-d02500f7fffe
 * source description   ::  complete tutorial for paging
 *
 * Source-3             ::  github
 * Source description   ::  https://github.com/mitchtabian/RestApiMVVM
 *  */

public class HeadlinesFragment extends Fragment {

    private static final String TAG = HeadlinesFragment.class.getSimpleName();
    private ArticleViewModel model;
    private RecyclerView recyclerViewHeadlines;
    private ArticleAdapter adapter;
    private ArrayList<Article> articleArrayList;
    ShimmerFrameLayout shimmerViewContainerHeadlines;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_headlines, container, false);

        initializations(root);

        setUpRecyclerView();

        getNewsHeadlines();

        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*ArticleDtoMapper mapper = new ArticleDtoMapper();

        List<Headline> headlineList = null;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);

        Call<HeadlinesResponse> articleResponse = service.getHeadlines("us", AppConstant.API_KEY);
        articleResponse.enqueue(new Callback<HeadlinesResponse>() {
            @Override
            public void onResponse(Call<HeadlinesResponse> call, Response<HeadlinesResponse> response) {
                if (response.body() != null) {

                    Log.d(TAG, "status :: " + response.body().getStatus());
                    //mapper.mapToDomainList(response.body().getHeadlineDtoList());
                }
            }

            @Override
            public void onFailure(Call<HeadlinesResponse> call, Throwable t) {

            }
        });*/


    }


    private void getNewsHeadlines() {
    /*    headlinesViewModel.getAllHeadlines().observe(getViewLifecycleOwner(), new Observer<HeadlinesResponse>() {
            @Override
            public void onChanged(HeadlinesResponse headlinesResponse) {
                shimmerViewContainerHeadlines.setVisibility(View.GONE);
                headlineArrayList.addAll(headlinesResponse.getHeadlines());
                adapter.notifyDataSetChanged();
            }
        });*/


        model.getArticleResponseLiveData().observe(
                getViewLifecycleOwner(),
                new Observer<ArticleResponse>() {
                    @Override
                    public void onChanged(ArticleResponse articleResponse) {
                        shimmerViewContainerHeadlines.setVisibility(View.GONE);
                        articleArrayList.addAll(articleResponse.getArticles());
                        adapter.notifyDataSetChanged();
                    }
                }
        );

    }

    private void setUpRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewHeadlines.setLayoutManager(layoutManager);
        adapter = new ArticleAdapter(getContext(), articleArrayList);
        recyclerViewHeadlines.setAdapter(adapter);
    }

    private void initializations(View root) {
        model = new ViewModelProvider(this).get(ArticleViewModel.class);
        articleArrayList = new ArrayList<>();
        recyclerViewHeadlines = root.findViewById(R.id.recyclerViewHeadlines);
        shimmerViewContainerHeadlines = root.findViewById(R.id.shimmerViewContainerHeadlines);
        shimmerViewContainerHeadlines.startShimmerAnimation();
    }


}
