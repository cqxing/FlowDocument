package com.cndatacom.flowdocument.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.cndatacom.flowdocument.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btn_personal_user;
    private ImageButton btn_enterprise_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_personal_user = (ImageButton) findViewById(R.id.btn_personal_user);
        btn_enterprise_user = (ImageButton) findViewById(R.id.btn_enterprise_user);

        btn_personal_user.setOnClickListener(this);
        btn_enterprise_user.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_personal_user:
                break;
            case R.id.btn_enterprise_user:
                break;
        }
    }
}
