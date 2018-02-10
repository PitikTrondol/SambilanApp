package com.sambilan.sambilan.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.sambilan.sambilan.SambilanApplication;
import com.sambilan.sambilan.model.Ad;
import com.sambilan.sambilan.model.response.AdResponse;
import com.sambilan.sambilan.model.response.JobResponse;
import com.sambilan.sambilan.presenter.LandingPagePresenter;
import com.sambilan.sambilan.presenter.ResponseResultCallback;
import com.sambilan.sambilan.view.DetailJobActivity;
import com.sambilan.sambilan.view.adapter.ListPekerjaanAdapter;
import com.sambilan.sambilan.view.adapter.SliderAdapter;
import com.sambilan.sambilan.view.adapter.listener.ListJobListener;
import com.sambilan.sambilan.view.helper.PageIndicatorHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andhika Putranto on 2/3/2018.
 */

public class LandingPageFragment extends Fragment {

    private final int DISPLAY_COUNT = 5;
    private final String TAG = "com.sambilan.sambilan";
    private int childCount, itemCount, firstVisibleItem, currentPage, totalPage;
    private boolean isLoading;
    private String appToken;

    private Toolbar topToolbar;
    private RecyclerView listJobRecyclerView;
    private ListPekerjaanAdapter listJobAdapter;
    private LandingPagePresenter landingPagePresenter;

    private ViewPager carouselViewPager;
    private LinearLayout carouselLinearLayout;
    private SliderAdapter carouselSliderAdapter;
    private LinearLayoutManager layoutManager;

    private PageIndicatorHelper carouselPageIndicator;
    private ProgressBar progressBar;

    private SwipeRefreshLayout recyclerRefresher;
    private List<Fragment> carouselFragment;

    public LandingPageFragment() {
        carouselFragment = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_landing_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appToken = ((SambilanApplication)getActivity().getApplication()).getAppToken();

        // Implementasi untuk topbar, menu dan search button
        carouselLinearLayout = view.findViewById(R.id.pagesContainer);
        listJobRecyclerView = view.findViewById(R.id.common_recycler_view);
        carouselViewPager = view.findViewById(R.id.carousel_pager);
        recyclerRefresher = view.findViewById(R.id.swipe_refresh_layout);
        progressBar = view.findViewById(R.id.progress_bar);
        topToolbar = view.findViewById(R.id.topBar);

        ((AppCompatActivity) getActivity()).setSupportActionBar(topToolbar);

        currentPage = 1;
        landingPagePresenter = new LandingPagePresenter();
//        landingPagePresenter.getHomeCarousel(carouselCallback);
        landingPagePresenter.getHomeJobList(homeJobCallback, appToken, currentPage, DISPLAY_COUNT);

        carouselSliderAdapter = new SliderAdapter(getActivity().getSupportFragmentManager(), getCarouselFragment());
        carouselViewPager.setAdapter(carouselSliderAdapter);

        carouselPageIndicator = new PageIndicatorHelper(getActivity(),
                carouselLinearLayout,
                R.drawable.indicator_circle,
                carouselViewPager);

        carouselPageIndicator.setPageCount(getCarouselFragment().size());
        carouselPageIndicator.show();

        progressBar.setVisibility(View.VISIBLE);
        recyclerRefresher.setOnRefreshListener(refreshListener);

        listJobAdapter = new ListPekerjaanAdapter(getContext());
        listJobAdapter.setListener(onClickJobListListener);

        layoutManager = new LinearLayoutManager(getContext());

        listJobRecyclerView.setLayoutManager(layoutManager);
        listJobRecyclerView.setAdapter(listJobAdapter);
        listJobRecyclerView.addOnScrollListener(scrollListener);
    }


    private List<Fragment> getCarouselFragment() {
        final List<Fragment> fragments = new ArrayList<>();
        String baseUrl = "https://trello-attachments.s3.amazonaws.com/5a54ee3b0dd4ebd39048d99c/5a5a29f1f4bb54c9978613fe/";

        fragments.add(SliderFragment.newInstance(baseUrl + "9ca5c580be3b78eab3f2bb2ebf117a89/couresel.png"));
        fragments.add(SliderFragment.newInstance(baseUrl + "848ff359644146c6f24e797601c437ed/couresel2.png"));
        fragments.add(SliderFragment.newInstance(baseUrl + "fdad02c8caf4ba33379169bfd74eee45/couresel3.png"));

        return fragments;
    }

    private ResponseResultCallback<AdResponse, Throwable> carouselCallback =
            new ResponseResultCallback<AdResponse, Throwable>() {
                @Override
                public void OnSuccessResult(AdResponse first) {
                    List<Fragment> fragments = new ArrayList<>();
                    for (Ad carousel : first.getData()) {
                        fragments.add(SliderFragment.newInstance(carousel.getImgUrl().trim()));
                    }

                    carouselSliderAdapter = new SliderAdapter(getActivity().getSupportFragmentManager(), fragments);
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(getActivity(),
                            "FAIL " + second.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            };

    private ResponseResultCallback<JobResponse, Throwable> homeJobCallback =
            new ResponseResultCallback<JobResponse, Throwable>() {
                @Override
                public void OnSuccessResult(JobResponse first) {
                    totalPage = first.getTotalPage();
                    listJobAdapter.setModel(first.getData());
                    progressBar.setVisibility(View.GONE);
                    recyclerRefresher.setRefreshing(false);
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(getActivity(),
                            "TEXT " + second.getMessage(),
                            Toast.LENGTH_SHORT).show();

                    progressBar.setVisibility(View.GONE);
                    recyclerRefresher.setRefreshing(false);
                }
            };

    private ResponseResultCallback<JobResponse, Throwable> itemScrollCallback =
            new ResponseResultCallback<JobResponse, Throwable>() {
                @Override
                public void OnSuccessResult(JobResponse first) {
                    listJobAdapter.appendModel(first.getData());

                    
                    progressBar.setVisibility(View.GONE);
                    recyclerRefresher.setRefreshing(false);
                    isLoading = false;
                }

                @Override
                public void OnFailureResult(Throwable second) {
                    Toast.makeText(getActivity(),
                            "TEXT " + second.getMessage(),
                            Toast.LENGTH_SHORT).show();

                    progressBar.setVisibility(View.GONE);
                    recyclerRefresher.setRefreshing(false);
                }
            };

    private ListJobListener onClickJobListListener =
            new ListJobListener() {
                @Override
                public void onClickJob(int jobID) {
                    Intent profileIntent = new Intent(getActivity(), DetailJobActivity.class);
                    startActivity(profileIntent);
                }
            };

    private RecyclerView.OnScrollListener scrollListener =
            new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                    childCount = layoutManager.getChildCount();
                    itemCount = layoutManager.getItemCount();

                    if (!isLoading &&
                            ((firstVisibleItem + DISPLAY_COUNT)) >= itemCount
                            && itemCount < (DISPLAY_COUNT * totalPage)) {

                        //kalo udah jadi, currentPage++
                        landingPagePresenter.getHomeJobList(itemScrollCallback, appToken, currentPage, DISPLAY_COUNT);

                        isLoading = true;
                    }
                }
            };

    private SwipeRefreshLayout.OnRefreshListener refreshListener =
            new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    landingPagePresenter.getHomeJobList(homeJobCallback, appToken, currentPage, DISPLAY_COUNT);
                }
            };
}
