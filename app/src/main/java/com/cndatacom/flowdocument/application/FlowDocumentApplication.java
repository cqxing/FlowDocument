package com.cndatacom.flowdocument.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by staring on 16-11-1.
 */

public class FlowDocumentApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true); // 是否输出debug日志, 开启debug会影响性能.
    }
}
