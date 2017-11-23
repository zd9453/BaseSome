package com.zhangdong.zdbase.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.zhangdong.zdbase.R;

/**
 * use to 各页面toolbar
 * <p>
 * Created by zhangdong on 2017/8/9.
 *
 * @version 1.0
 */

public class ZdToolBar extends RelativeLayout {

    public ZdToolBar(Context context) {
        super(context);
    }

    public ZdToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZdToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_zdtoolbar, null);

    }
}
