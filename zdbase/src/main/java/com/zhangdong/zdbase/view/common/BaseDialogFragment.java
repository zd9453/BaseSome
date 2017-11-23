package com.zhangdong.zdbase.view.common;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangdong.zdbase.R;
import com.zhangdong.zdbase.view.utils.DisplayUtils;

/**
 * use to 弹窗基类
 * <p>
 * Created by zhangdong on 2017/11/23.
 *
 * @version 1.0
 */

public abstract class BaseDialogFragment extends DialogFragment {
    private Context mContext;
    private View contentView;

    /**
     * 与activity绑定时，保存当前context
     *
     * @param context .
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    /**
     * 创建dialog,可以做一些dialog的配置
     *
     * @param savedInstanceState .
     * @return dialog
     */
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //创建dialog设置style样式
        Dialog dialog = new Dialog(mContext, R.style.zdBaseDialogStyle);
        //可点击其他区域消失
        dialog.setCanceledOnTouchOutside(true);
        //点击返回键dialog消失
        dialog.setCancelable(true);
        //其他配置
        configDialog(dialog);
        return dialog;
    }

    /**
     * 对dialog的一些其他配置
     * 可配置弹出位置，弹出动画
     * 在此方法中设置弹窗的宽高无效（若要设置宽高可以在onStart()方法中设置）
     */
    protected void configDialog(Dialog dialog) {

    }

    /**
     * 创建视图的时候，加载布局，绑定监听等操作
     *
     * @return 视图
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(getLayoutId(), container);
        initView(contentView);
        initListener(contentView);
        return contentView;
    }

    /**
     * 初始化监听
     *
     * @param contentView 弹窗布局
     */
    protected void initListener(View contentView) {

    }

    /**
     * 初始化view，一般做找控件操作
     *
     * @param contentView 弹窗布局
     */
    protected void initView(View contentView) {

    }

    /**
     * 获取布局资源Id
     *
     * @return 资源id
     */
    protected abstract int getLayoutId();

    /**
     * 视图创建完成后，可以在此方法中做一些数据初始化操作
     */
    @Override
    public void onStart() {
        super.onStart();
        configWidthHeight(getDialog(), DisplayUtils.getWight(mContext), DisplayUtils.getHeight(mContext));
        getDate(mContext);
    }

    /**
     * 配置dialog的宽高
     *
     * @param dialog dialog
     * @param wight  .
     * @param height .
     */
    protected void configWidthHeight(Dialog dialog, int wight, int height) {


    }

    /**
     * 获取数据
     */
    protected void getDate(Context mContext) {

    }

    /**
     * 销毁释放资源
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null) {
            mContext = null;
        }
        if (contentView != null) {
            contentView = null;
        }
    }
}
