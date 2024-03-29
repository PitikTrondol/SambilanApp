package com.sambilan.sambilan.view.helper;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Andhika Putranto on 1/19/2018.
 */

public class PageIndicatorHelper implements ViewPager.OnPageChangeListener {
    private Context sContext;
    private LinearLayout container;
    private int drawable;
    private int spacing;
    private int size;
    private ViewPager sViewPager;
    private int pageCount;
    private int initialPage = 0;

    private int defaultSizeInDp = 12;
    private int defaultSpacingInDp = 12;
//
//    public PageIndicatorHelper(@NonNull Context context, @NonNull LinearLayout containerView, @NonNull ViewPager viewPager, @DrawableRes int drawableRes) {
//
//        this.sContext = context;
//        this.container = containerView;
//        this.drawable = drawableRes;
//        this.sViewPager = viewPager;
//
//    }

    public PageIndicatorHelper(@NonNull Context sContext,@NonNull LinearLayout container,@DrawableRes int drawable,@NonNull ViewPager sViewPager) {
        this.sContext = sContext;
        this.container = container;
        this.drawable = drawable;
        this.sViewPager = sViewPager;
    }

    public void setPageCount(int pageCount) {
        pageCount = pageCount;
    }

    public void setInitialPage(int page) {
        initialPage = page;
    }

    public void setDrawable(@DrawableRes int drawable) {
        drawable = drawable;
    }

    public void setSpacingRes(@DimenRes int spacingRes) {
        spacing = spacingRes;
    }

    public void setSize(@DimenRes int dimenRes) {
        size = dimenRes;
    }

    public void show() {
        initIndicators();
        setIndicatorAsSelected(initialPage);
    }

    private void initIndicators() {
        if (container == null || pageCount <= 0) {
            return;
        }

        sViewPager.addOnPageChangeListener(this);
        Resources res = sContext.getResources();
        container.removeAllViews();
        for (int i = 0; i < pageCount; i++) {
            View view = new View(sContext);
            int dimen = size != 0 ? res.getDimensionPixelSize(size) : ((int) res.getDisplayMetrics().density * defaultSizeInDp);
            int margin = spacing != 0 ? res.getDimensionPixelSize(spacing) : ((int) res.getDisplayMetrics().density * defaultSpacingInDp);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(dimen, dimen);
            lp.setMargins(i == 0 ? 0 : margin, 0, 0, 0);

            view.setLayoutParams(lp);
            view.setBackgroundResource(drawable);
            view.setSelected(i == 0);
            container.addView(view);
        }
    }

    private void setIndicatorAsSelected(int index) {
        if (container == null) {
            return;
        }
        for (int i = 0; i < container.getChildCount(); i++) {
            View view = container.getChildAt(i);
            view.setSelected(i == index);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Toast.makeText(sContext, "pos " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageSelected(int position) {
        int index = position;
        setIndicatorAsSelected(index);

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    public void cleanup() {
        sViewPager.clearOnPageChangeListeners();
    }
}
