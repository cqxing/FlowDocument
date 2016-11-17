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

public class EnterpriseRegisterLoginFragment extends Fragment {
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    private static final String WHICH_SELECT = "which_select";

//    private String mParam1;
//    private String mParam2;

    private int which_select = -1;

    private Context mContext = getContext();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"注册", "登陆"};
    private RegisterLoginPagerAdapter mAdapter;

    private OnFragmentInteractionListener mListener;

    public EnterpriseRegisterLoginFragment() {
    }

    public static EnterpriseRegisterLoginFragment newInstance() {
        EnterpriseRegisterLoginFragment fragment = new EnterpriseRegisterLoginFragment();
        return fragment;
    }

    public static EnterpriseRegisterLoginFragment newInstance(int which_select) {
        EnterpriseRegisterLoginFragment fragment = new EnterpriseRegisterLoginFragment();
        Bundle args = new Bundle();
        args.putInt(WHICH_SELECT, which_select);
        fragment.setArguments(args);
        return fragment;
    }

//    public static EnterpriseRegisterLoginFragment newInstance(String param1, String param2) {
//        EnterpriseRegisterLoginFragment fragment = new EnterpriseRegisterLoginFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            which_select = getArguments().getInt(WHICH_SELECT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_personal_register_login, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mFragments.add(0, EnterpriseRegisterFragment.newInstance());
        mFragments.add(1, EnterpriseLoginFragment.newInstance());
        ViewPager vp = ViewFindUtils.find(view, R.id.viewpager);
        mAdapter = new RegisterLoginPagerAdapter(this.getChildFragmentManager());
        vp.setAdapter(mAdapter);
        SlidingTabLayout tabLayout_9 = ViewFindUtils.find(view, R.id.tl_9_register_login);

        tabLayout_9.setViewPager(vp);
        if (which_select != -1) {
            tabLayout_9.setCurrentTab(which_select);
        }
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

    private class RegisterLoginPagerAdapter extends FragmentPagerAdapter {
        public RegisterLoginPagerAdapter(FragmentManager fm) {
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
