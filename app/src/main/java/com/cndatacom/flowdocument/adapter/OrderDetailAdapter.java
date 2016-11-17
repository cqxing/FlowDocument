package com.cndatacom.flowdocument.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cndatacom.flowdocument.R;
import com.cndatacom.flowdocument.bean.AppKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by staring on 16-11-2.
 */

public class OrderDetailAdapter extends BaseQuickAdapter<AppKey> {


    public OrderDetailAdapter() {
        super(R.layout.list_item_personal_order_detail, getlist());
    }

    private static List<AppKey> getlist() {
        ArrayList<AppKey> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AppKey appKey = new AppKey();
            list.add(appKey);
        }
        return list;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, AppKey appKey) {
    }
}