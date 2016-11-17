package com.cndatacom.flowdocument.activity.personal;

import android.content.Intent;
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
import com.cndatacom.flowdocument.bean.VerificationCode;
import com.cndatacom.flowdocument.constant.ServerConstants;
import com.cndatacom.flowdocument.fragment.personal.PersonalCenterFragment;
import com.cndatacom.flowdocument.fragment.personal.RegisterLoginFragment;
import com.cndatacom.flowdocument.utils.DateUtils;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.common.util.MD5;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Date;

public class MainPersonalActivity extends AppCompatActivity implements View.OnClickListener {

    private View bottom_View_register_login;
    private View bottom_View_personal_center;

    private static final String BOTTOM_REGISTER_LOGIN = "bottom_register_login";
    private static final String BOTTOM_PERSONAL_CENTERSTRING = "bottom_personal_center";

    private boolean bottom_register_login_isShowing = false;//bottom_view is show or not
    private boolean bottom_personal_center_isShowing = false;//bottom_view is show or not

    private RegisterLoginFragment registerLoginFragment;
    private PersonalCenterFragment personalCenterFragment;

    private TextView login;//login
    private TextView register;//register

    private LinearLayout product_order;
    private LinearLayout donation_time;
    private LinearLayout query_detail;
    private LinearLayout personal_center;

    private long mExitTime;

    private final String WHICH_SELECT = "which_select";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_main);
        initView();
//        TestServer();
    }

    private void TestServer() {
        RequestParams requestParams = new RequestParams(ServerConstants.getVerificationCode);
        requestParams.addBodyParameter("email", "15088132565@163.com");
        requestParams.addBodyParameter("type", "1");
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5("cndatacom2016" + timestamp));
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                VerificationCode verificationCode = gson.fromJson(result, VerificationCode.class);
                LogUtil.e(verificationCode.toString());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void initView() {

        bottom_View_register_login = findViewById(R.id.Layout_bottom_register_login);
        bottom_View_personal_center = findViewById(R.id.Layout_bottom_personal_center);

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

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                registerLoginFragment = RegisterLoginFragment.newInstance(1);
                addFragment(bottom_View_register_login, registerLoginFragment, BOTTOM_REGISTER_LOGIN);
                break;
            case R.id.register:
                registerLoginFragment = RegisterLoginFragment.newInstance(0);
                addFragment(bottom_View_register_login, registerLoginFragment, BOTTOM_REGISTER_LOGIN);
                break;
            case R.id.product_order:
                Intent intent_po = new Intent(this, OrderDonationActivity.class);
                intent_po.putExtra(WHICH_SELECT, 0);
                startActivity(intent_po);
                overridePendingTransition(R.anim.left, R.anim.left_hide);
                break;
            case R.id.donation_time:
                Intent intent_dt = new Intent(this, OrderDonationActivity.class);
                intent_dt.putExtra(WHICH_SELECT, 1);
                startActivity(intent_dt);
                overridePendingTransition(R.anim.left, R.anim.left_hide);
                break;
            case R.id.query_detail:
                Intent intent_qd = new Intent(this, QueryDetailActivity.class);
                startActivity(intent_qd);
                overridePendingTransition(R.anim.right, R.anim.right_hide);
                break;
            case R.id.personal_center:
                personalCenterFragment = PersonalCenterFragment.newInstance();
                addFragment(bottom_View_personal_center, personalCenterFragment, BOTTOM_PERSONAL_CENTERSTRING);
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //click the other view to hide the bottomView
        if (bottom_register_login_isShowing && isNotClickBottom(ev, bottom_View_register_login)) {
            removeFragment(bottom_View_register_login, registerLoginFragment, BOTTOM_REGISTER_LOGIN);
            return true;
        }
        if (bottom_personal_center_isShowing && isNotClickBottom(ev, bottom_View_personal_center)) {
            removeFragment(bottom_View_personal_center, personalCenterFragment, BOTTOM_PERSONAL_CENTERSTRING);
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    //is or not click the bottom view
    private boolean isNotClickBottom(MotionEvent ev, View view) {
        int leftTop[] = {0, 0};
        if (view != null) {
            view.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + view.getHeight();
            int right = left + view.getWidth();
            if (ev.getX() > left && ev.getX() < right && ev.getY() > top && ev.getY() < bottom) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean isShow() {
        return bottom_personal_center_isShowing || bottom_register_login_isShowing;
    }

    //add the Fragment to the right place
    private void addFragment(final View view, final Fragment fragment, final String tag) {
        if (isShow()) return;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        int animation_in = R.anim.bottom;
        int animation_out = R.anim.bottom_hide;

        int layout_id = 0;

        switch (tag) {
            case BOTTOM_REGISTER_LOGIN:
                layout_id = R.id.Layout_bottom_register_login;
                bottom_register_login_isShowing = true;
                break;
            case BOTTOM_PERSONAL_CENTERSTRING:
                layout_id = R.id.Layout_bottom_personal_center;
                bottom_personal_center_isShowing = true;
                break;
        }

        transaction.setCustomAnimations(animation_in, animation_out);
        view.setVisibility(View.VISIBLE);

        transaction.add(layout_id, fragment);
        transaction.commit();
    }

    private void removeFragment(final View view, final Fragment fragment, final String tag) {
        FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bottom_hide);
        switch (tag) {
            case BOTTOM_REGISTER_LOGIN:
                bottom_register_login_isShowing = false;
                break;
            case BOTTOM_PERSONAL_CENTERSTRING:
                bottom_personal_center_isShowing = false;
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


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (bottom_register_login_isShowing) {
                removeFragment(bottom_View_register_login, registerLoginFragment, BOTTOM_REGISTER_LOGIN);
                return true;
            }
            if (bottom_personal_center_isShowing) {
                removeFragment(bottom_View_personal_center, personalCenterFragment, BOTTOM_PERSONAL_CENTERSTRING);
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
