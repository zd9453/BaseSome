package com.zhangdong.viewpagefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager layPager1;
    private ViewPager layPager2;
    private TestViewPagerAdapter pagerAdapter1;
    private TestViewPagerAdapter pagerAdapter2;
    List<Fragment> fragments1 = new ArrayList<>();
    List<Fragment> fragments2 = new ArrayList<>();

    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layPager1 = (ViewPager) findViewById(R.id.layPager1);
        layPager2 = (ViewPager) findViewById(R.id.layPager2);

        layPager1.setVisibility(View.VISIBLE);
        layPager2.setVisibility(View.INVISIBLE);

        getFragment1();
        getFragment2();

        pagerAdapter1 = new TestViewPagerAdapter(getSupportFragmentManager(), fragments1);
        layPager1.setAdapter(pagerAdapter1);

        pagerAdapter2 = new TestViewPagerAdapter(getSupportFragmentManager(), fragments2);
        layPager2.setAdapter(pagerAdapter2);

    }

    private void getFragment1() {
        for (int i = 0; i < 8; i++) {
            fragments1.add(ViewFragment.newInstance("this is layPager1 fragment" + (i + 1)));
        }
    }

    private void getFragment2() {
        for (int i = 0; i < 13; i++) {
            fragments2.add(ViewFragment.newInstance("this is layPager2 fragment" + (i + 1)));
        }
    }


    public void doOneChange(View view) {
        layPager1.setVisibility(View.VISIBLE);
        layPager2.setVisibility(View.GONE);

        if (cont < fragments1.size()) {
            Collections.swap(fragments1, 0, cont);
            Toast.makeText(this, "cont:" + cont, Toast.LENGTH_SHORT).show();
            cont++;
        } else {
            cont = 0;
            Collections.swap(fragments1, 0, cont);
            Toast.makeText(this, "cont:" + cont, Toast.LENGTH_SHORT).show();
            cont++;
        }
        pagerAdapter1.notifyDataSetChanged();
    }

    public void doTwoChange(View view) {
        layPager1.setVisibility(View.GONE);
        layPager2.setVisibility(View.VISIBLE);

        if (cont < fragments2.size()) {
            Collections.swap(fragments2, 0, cont);
            Toast.makeText(this, "cont:" + cont, Toast.LENGTH_SHORT).show();
            cont++;
        } else {
            cont = 0;
            Collections.swap(fragments2, 0, cont);
            Toast.makeText(this, "cont:" + cont, Toast.LENGTH_SHORT).show();
            cont++;
        }
        pagerAdapter2.notifyDataSetChanged();
    }
}
