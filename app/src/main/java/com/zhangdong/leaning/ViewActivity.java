package com.zhangdong.leaning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhangdong.leaning.dialog.TestDialog;
import com.zhangdong.zdbase.view.view.TestView;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {

    private TestDialog testDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        TestView testView = (TestView) findViewById(R.id.test_view);
        testView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (testDialog == null) {
            testDialog = TestDialog.newInstance();
        }
        testDialog.show(getSupportFragmentManager(), "this is");
    }
}
