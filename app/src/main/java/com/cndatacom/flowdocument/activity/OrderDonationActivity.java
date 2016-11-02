package com.cndatacom.flowdocument.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;

import com.cndatacom.flowdocument.R;
import com.cndatacom.flowdocument.fragment.DonationTimeFragment;
import com.cndatacom.flowdocument.fragment.OrderProductFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class OrderDonationActivity extends FragmentActivity {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"产品订购", "时长转赠"};
    private OrderDonationPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_order_donation, null);
        setContentView(view);
        initView();
    }

    private void initView() {
        mFragments.add(0, OrderProductFragment.newInstance());
        mFragments.add(1, DonationTimeFragment.newInstance());
        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
        mAdapter = new OrderDonationPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);
        SlidingTabLayout tabLayout_9 = (SlidingTabLayout) findViewById(R.id.tl_9_order_donation_activity);
        tabLayout_9.setViewPager(vp);
    }

    private class OrderDonationPagerAdapter extends FragmentPagerAdapter {
        public OrderDonationPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            overridePendingTransition(R.anim.left, R.anim.left_hide);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
