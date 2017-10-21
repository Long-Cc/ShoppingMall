package com.longc.shoppingmall.Fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.longc.shoppingmall.base.BaseFragment;

/**
 * Created by longc on 2017/2/10.
 */
public class CommunityFragment extends BaseFragment {
    private TextView textView;
    @Override
    protected View initView() {
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(30);
        textView.setTextColor(Color.GREEN);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        textView.setText("发现");
    }
}
