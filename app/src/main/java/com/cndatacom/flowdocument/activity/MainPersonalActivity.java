package com.cndatacom.flowdocument.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cndatacom.flowdocument.R;
import com.cndatacom.flowdocument.fragment.RegisterLoginFragment;

public class MainPersonalActivity extends AppCompatActivity implements View.OnClickListener {

    private View product_order_and_donation_time_View;
    private View query_detail_View;
    private View bottom_View;
    private View main_View;

    private static final String BOTTOM = "bottom";
    private static final String PRODUCT_DONATION = "product_order_and_donation_time";
    private static final String QUERY_DETAIL = "query_detail";
    private boolean bottom_isShowing = false;
    private boolean product_order_and_donation_time_isShowing = false;
    private boolean query_detail_isShowing = false;

    private RegisterLoginFragment registerLoginFragment;

    private TextView login;
    private TextView register;

    private LinearLayout product_order;
    private LinearLayout donation_time;
    private LinearLayout query_detail;
    private LinearLayout personal_center;

    private long mExitTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_personal);
        initView();
    }

    private void initView() {

        product_order_and_donation_time_View = findViewById(R.id.Layout_product_order_and_donation_time);
        query_detail_View = findViewById(R.id.Layout_query_detail);
        bottom_View = findViewById(R.id.Layout_bottom);
        main_View = findViewById(R.id.Layout_main);

        login = (TextView) findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);

        login.setOnClickListener(this);
        register.setOnClickListener(this);

        product_order = (LinearLayout) findViewById(R.id.product_order);
        donation_time = (LinearLayout) findViewById(R.id.donation_time);
        query_detail = (LinearLayout) findViewById(R.id.query_detail);
        personal_center = (LinearLayout) findViewById(R.id.personal_center);

        product_order.setOnClickListener(this);
        donation_time.setOnClickListener(this);
        query_detail.setOnClickListener(this);
        personal_center.setOnClickListener(this);

        if (registerLoginFragment == null) {
            registerLoginFragment = RegisterLoginFragment.newInstance();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                Toast.makeText(this, getResources().getString(R.string.login), Toast.LENGTH_SHORT).show();
                break;
            case R.id.register:
                Toast.makeText(this, getResources().getString(R.string.register), Toast.LENGTH_SHORT).show();
                break;
            case R.id.product_order:
                Toast.makeText(this, getResources().getString(R.string.product_order), Toast.LENGTH_SHORT).show();
                break;
            case R.id.donation_time:
                Toast.makeText(this, getResources().getString(R.string.donation_time), Toast.LENGTH_SHORT).show();
                break;
            case R.id.query_detail:
                Toast.makeText(this, getResources().getString(R.string.query_detail), Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_center:
                Toast.makeText(this, getResources().getString(R.string.personal_center), Toast.LENGTH_SHORT).show();

                if (!registerLoginFragment.isAdded()) {
//                    main_View.setAlpha((float) 0.7);
                    addFragment(bottom_View, registerLoginFragment, BOTTOM);
                } else if (bottom_isShowing) {
//                    main_View.setAlpha((float) 1);
                    hideFragment(bottom_View, registerLoginFragment, BOTTOM);
                } else {
//                    main_View.setAlpha((float) 0.7);
                    showFragment(bottom_View, BOTTOM);
                }

                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (bottom_isShowing && isNotClickBottom(ev)) {
            hideFragment(bottom_View, registerLoginFragment, BOTTOM);
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    //is or not click the bottom view
    private boolean isNotClickBottom(MotionEvent ev) {
        int leftTop[] = {0, 0};
        if (bottom_View != null) {
            bottom_View.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + bottom_View.getHeight();
            int right = left + bottom_View.getWidth();
            if (ev.getX() > left && ev.getX() < right && ev.getY() > top && ev.getY() < bottom) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean isShow() {
        return product_order_and_donation_time_isShowing || query_detail_isShowing || bottom_isShowing;
    }

    //add the Fragment to the right place
    private void addFragment(final View view, final Fragment fragment, final String tag) {
        if (isShow()) return;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        int animation_in = 0;
        int animation_out = 0;

        int layout_id = 0;

        switch (tag) {
            case PRODUCT_DONATION:
                animation_in = R.anim.left;
                animation_out = R.anim.left_hide;
                layout_id = R.id.Layout_product_order_and_donation_time;
                product_order_and_donation_time_isShowing = true;
                break;
            case QUERY_DETAIL:
                animation_in = R.anim.right;
                animation_out = R.anim.right_hide;
                layout_id = R.id.Layout_query_detail;
                query_detail_isShowing = true;
                break;
            case BOTTOM:
                animation_in = R.anim.bottom;
                animation_out = R.anim.bottom_hide;
                layout_id = R.id.Layout_bottom;
                bottom_isShowing = true;
                break;
        }

        transaction.setCustomAnimations(animation_in, animation_out);

//        view.setAlpha((float) 0.8);
        view.setVisibility(View.VISIBLE);

        transaction.add(layout_id, fragment);
        transaction.commit();
    }

    private void removeFragment(final View view, final Fragment fragment, final String tag) {
        FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        Animation animation = null;
        switch (tag) {
            case PRODUCT_DONATION:
                animation = AnimationUtils.loadAnimation(this, R.anim.left_hide);
                product_order_and_donation_time_isShowing = false;
                break;
            case QUERY_DETAIL:
                animation = AnimationUtils.loadAnimation(this, R.anim.right_hide);
                query_detail_isShowing = false;
                break;
            case BOTTOM:
                animation = AnimationUtils.loadAnimation(this, R.anim.bottom_hide);
                bottom_isShowing = false;
                break;
        }

        if (animation == null) {
            try {
                throw new Exception("have no tag");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                transaction.remove(fragment);
                transaction.commit();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
        view.setVisibility(View.GONE);
    }

    //just show the Fragment with Animation
    private void showFragment(View view, String tag) {
        if (isShow()) return;
        Animation animation = null;
        switch (tag) {
            case PRODUCT_DONATION:
                animation = AnimationUtils.loadAnimation(this, R.anim.left);
                product_order_and_donation_time_isShowing = true;
                break;
            case QUERY_DETAIL:
                animation = AnimationUtils.loadAnimation(this, R.anim.right);
                query_detail_isShowing = true;
                break;
            case BOTTOM:
                animation = AnimationUtils.loadAnimation(this, R.anim.bottom);
                bottom_isShowing = true;
                break;
        }
        if (animation == null) {
            try {
                throw new Exception("have no tag");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        view.startAnimation(animation);
        view.setVisibility(View.VISIBLE);

    }

    //just hide the Fragment
    public void hideFragment(View view, final Fragment fragment, String tag) {
        Animation animation = null;
        switch (tag) {
            case PRODUCT_DONATION:
                animation = AnimationUtils.loadAnimation(this, R.anim.left_hide);
                product_order_and_donation_time_isShowing = false;
                break;
            case QUERY_DETAIL:
                animation = AnimationUtils.loadAnimation(this, R.anim.right_hide);
                query_detail_isShowing = false;
                break;
            case BOTTOM:
                animation = AnimationUtils.loadAnimation(this, R.anim.bottom_hide);
                bottom_isShowing = false;
                break;
        }

        if (animation == null) {
            try {
                throw new Exception("have no tag");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        view.startAnimation(animation);
        view.setVisibility(View.GONE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (query_detail_isShowing) {
                return true;
            }
            if (product_order_and_donation_time_isShowing) {
                return true;
            }
            if (bottom_isShowing) {
                hideFragment(bottom_View, registerLoginFragment, BOTTOM);
                return true;
            }

            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, getResources().getString(R.string.logout), Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
                return true;
            } else {
                finish();
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
