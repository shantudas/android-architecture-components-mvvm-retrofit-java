package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view.ui.Headlines;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter.HeadlinesAdapter;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Headline;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.HeadlinesResponse;

import java.util.ArrayList;
import java.util.List;


public class HeadlinesFragment extends Fragment {

    private static final String TAG = HeadlinesFragment.class.getSimpleName();
    private HeadlinesViewModel headlinesViewModel;
    private RecyclerView recyclerViewHeadlines;
    private HeadlinesAdapter adapter;
    private ArrayList<Headline> headlineArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        initializations(root);

        setUpRecyclerView();

        getNewsHeadlines();

        return root;
    }

    private void getNewsHeadlines() {
        headlinesViewModel.init();
        headlinesViewModel.getAllHeadlines().observe(getViewLifecycleOwner(), new Observer<HeadlinesResponse>() {
            @Override
            public void onChanged(HeadlinesResponse headlinesResponse) {
                List<Headline> headlines = headlinesResponse.getHeadlines();
                headlineArrayList.addAll(headlines);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void setUpRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewHeadlines.setLayoutManager(layoutManager);
        adapter = new HeadlinesAdapter(getContext(), headlineArrayList);
        recyclerViewHeadlines.setAdapter(adapter);
    }

    private void initializations(View root) {
        headlinesViewModel = ViewModelProviders.of(this).get(HeadlinesViewModel.class);
        recyclerViewHeadlines = root.findViewById(R.id.recyclerViewHeadlines);
    }


}
