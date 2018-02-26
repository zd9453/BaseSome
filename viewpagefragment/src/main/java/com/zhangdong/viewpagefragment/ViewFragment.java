package com.zhangdong.viewpagefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * use to
 * <p>
 * Created by zhangdong on 2018/2/26.
 *
 * @version 1.0
 */

public class ViewFragment extends Fragment {
    public static final String EXTR = "ViewFragment";
    private TextView textView;

    public static ViewFragment newInstance(String tag) {
        ViewFragment fragment = new ViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTR, tag);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.layout_fragment, container, false);
        textView = ((TextView) inflate.findViewById(R.id.textView));
        return inflate;
    }

    @Override
    public void onStart() {
        super.onStart();
        String string = getArguments().getString(EXTR);
        textView.setText(string);
    }

    public void doThing() {
        Toast.makeText(getContext(), textView.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
