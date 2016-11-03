package com.cndatacom.flowdocument.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cndatacom.flowdocument.R;
import com.cndatacom.flowdocument.bean.DemoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by staring on 16-11-2.
 */

public class OrderDetailAdapter extends BaseQuickAdapter<DemoBean> {


    public OrderDetailAdapter() {
        super(R.layout.list_item_order_detail, getlist());
    }

    private static List<DemoBean> getlist() {
        ArrayList<DemoBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoBean demoBean = new DemoBean();
            demoBean.setStr1("test1");
            demoBean.setStr2("test2");
            demoBean.setStr3("test3");
            list.add(demoBean);
        }
        return list;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DemoBean demoBean) {
//        baseViewHolder.setText(R.id.test1, demoBean.getStr1());
    }
}