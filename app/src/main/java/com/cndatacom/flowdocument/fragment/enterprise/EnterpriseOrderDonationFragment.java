package com.cndatacom.flowdocument.fragment.enterprise;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cndatacom.flowdocument.R;
import com.cndatacom.flowdocument.utils.ViewFindUtils;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class EnterpriseOrderDonationFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Context mContext = getContext();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"产品订购", "时长转赠"};
    private OrderDonationPagerAdapter mAdapter;

    private OnFragmentInteractionListener mListener;

    public EnterpriseOrderDonationFragment() {
    }

    public static EnterpriseOrderDonationFragment newInstance() {
        EnterpriseOrderDonationFragment fragment = new EnterpriseOrderDonationFragment();
        return fragment;
    }

    public static EnterpriseOrderDonationFragment newInstance(String param1, String param2) {
        EnterpriseOrderDonationFragment fragment = new EnterpriseOrderDonationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_personal_order_donation, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mFragments.add(0, EnterpriseOrderProductFragment.newInstance());
        mFragments.add(1, EnterpriseDonationTimeFragment.newInstance());
        ViewPager vp = ViewFindUtils.find(view, R.id.viewpager);
        mAdapter = new OrderDonationPagerAdapter(this.getFragmentManager());
        vp.setAdapter(mAdapter);
        SlidingTabLayout tabLayout_9 = ViewFindUtils.find(view, R.id.tl_9_order_donation);

        tabLayout_9.setViewPager(vp);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
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
}
