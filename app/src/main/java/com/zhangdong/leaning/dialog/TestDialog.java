package com.zhangdong.leaning.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.zhangdong.leaning.R;
import com.zhangdong.zdbase.view.common.BaseDialogFragment;
import com.zhangdong.zdbase.view.utils.DisplayUtils;

/**
 * use to
 * <p>
 * Created by zhangdong on 2017/11/23.
 *
 * @version 1.0
 */

public class TestDialog extends BaseDialogFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.layout_test_dialog;
    }

    public static TestDialog newInstance() {
        Bundle bundle = new Bundle();
        TestDialog dialog = new TestDialog();
        dialog.setArguments(bundle);
        return dialog;
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected void initView(View contentView) {
    }

    @Override
    protected void configDialog(Dialog dialog) {
        dialog.getWindow().setGravity(Gravity.TOP);
        if (dialog.getWindow() != null)
            dialog.getWindow().getAttributes().windowAnimations = R.style.dialogPushAnim;
    }

    @Override
    protected void configWidthHeight(Dialog dialog, int wight, int height) {
        dialog.getWindow().setLayout((int) (wight * 0.8), DisplayUtils.dp2px(getContext(), 200));
    }
}
