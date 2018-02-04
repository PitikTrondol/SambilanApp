package com.sambilan.sambilan.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sambilan.sambilan.R;
import com.sambilan.sambilan.model.LandingPageResponse;
import com.sambilan.sambilan.presenter.LandingPagePresenter;
import com.sambilan.sambilan.view.DetailJobActivity;
import com.sambilan.sambilan.view.adapter.ListPekerjaanAdapter;
import com.sambilan.sambilan.view.adapter.SliderAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListJobListener;
import com.sambilan.sambilan.view.helper.PageIndicatorHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.HttpException;

/**
 * Created by Andhika Putranto on 2/3/2018.
 */

public class LandingPageFragment extends Fragment {


    private Toolbar topToolbar;
    private RecyclerView listJobRecyclerView;
    private LandingPagePresenter listJobPresenter;
    private ListPekerjaanAdapter listJobAdapter;

    private ViewPager carouselViewPager;
    private LinearLayout carouselLinearLayout;
    private SliderAdapter carouselSliderAdapter;
    private PageIndicatorHelper carouselPageIndicator;

    private BottomNavigationView bottomNavigationView;
    private ProgressBar progressBar;
    private SwipeRefreshLayout recyclerRefresher;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_landing_page, container, false);
        topToolbar = view.findViewById(R.id.topBar);
        // Implementasi untuk topbar, menu dan search button
        topToolbar = view.findViewById(R.id.topBar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(topToolbar);
        // Implementasi carousel
        carouselViewPager = view.findViewById(R.id.carousel_pager);
        carouselLinearLayout = view.findViewById(R.id.pagesContainer);

        carouselSliderAdapter = new SliderAdapter(getActivity().getSupportFragmentManager(), getCarouselFragment());
        carouselViewPager.setAdapter(carouselSliderAdapter);
        carouselPageIndicator = new PageIndicatorHelper(getActivity(), carouselLinearLayout, R.drawable.indicator_circle, carouselViewPager);
        carouselPageIndicator.setPageCount(getCarouselFragment().size());
        carouselPageIndicator.show();

        // Implementasi untuk recyclerview
        listJobPresenter = new LandingPagePresenter();
        listJobPresenter.getAllResources(jobCallback, "employer");

        listJobAdapter = new ListPekerjaanAdapter(getActivity());
        listJobAdapter.setListener(jobListener);

        listJobRecyclerView = view.findViewById(R.id.common_recycler_view);
        listJobRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listJobRecyclerView.setAdapter(listJobAdapter);

        progressBar = view.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        recyclerRefresher = view.findViewById(R.id.swipe_refresh_layout);
        recyclerRefresher.setOnRefreshListener(refreshListener);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private List<Fragment> getCarouselFragment() {
        List<Fragment> fragments = new ArrayList<>();
        String baseUrl = "https://trello-attachments.s3.amazonaws.com/5a54ee3b0dd4ebd39048d99c/5a5a29f1f4bb54c9978613fe/";

        fragments.add(SliderFragment.newInstance(baseUrl + "9ca5c580be3b78eab3f2bb2ebf117a89/couresel.png"));
        fragments.add(SliderFragment.newInstance(baseUrl + "848ff359644146c6f24e797601c437ed/couresel2.png"));
        fragments.add(SliderFragment.newInstance(baseUrl + "fdad02c8caf4ba33379169bfd74eee45/couresel3.png"));

        return fragments;
    }

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            listJobPresenter.getAllResources(jobCallback, "employer");
        }
    };

    private LandingPagePresenter.JobResultCallback<LandingPageResponse, Throwable>
            jobCallback = new LandingPagePresenter.JobResultCallback<LandingPageResponse, Throwable>() {

        @Override
        public void OnSuccessResult(LandingPageResponse first) {
            listJobAdapter.updateModel(first.getData());
            progressBar.setVisibility(View.GONE);
            recyclerRefresher.setRefreshing(false);
        }

        @Override
        public void OnFailureResult(Throwable second) {

            Toast.makeText(getActivity(),
                    "TELEK " + second.getMessage(),
                    Toast.LENGTH_SHORT).show();

            progressBar.setVisibility(View.GONE);
            recyclerRefresher.setRefreshing(false);
        }
    };
    private ListJobListener jobListener = new ListJobListener() {
        @Override
        public void onClickJob() {
            Intent profileIntent = new Intent(getActivity(), DetailJobActivity.class);
            startActivity(profileIntent);
        }
    };

}
