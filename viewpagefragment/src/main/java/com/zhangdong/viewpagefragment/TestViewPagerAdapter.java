package com.zhangdong.viewpagefragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * use to
 * <p>
 * Created by zhangdong on 2018/2/26.
 *
 * @version 1.0
 */

public class TestViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    public TestViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
//        Fragment fragment = null;
//        if (fragments.size() > position) {
//            fragment = fragments.get(position);
//            if (fragment != null) {
//                return fragment;
//            }
//        }
//
//        while (position>=fragments.size()) {
//            fragments.add(null);
//        }
//
//
//        fragment = Fragment.newPage(pageList.get(position),position);
//        pages.set(position, page);
//        return page;
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }
}
