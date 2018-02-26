package com.zhangdong.leaning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.TextView;

import com.zhangdong.zdbase.view.utils.DisplayUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MY_INFO";
    private ViewPager groupPager;
    private RecyclerView rcv_group_name;
    private GroupNameAdapter mAdapter;
    private TextView tvWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvWorld = (TextView) findViewById(R.id.tv_world);
        groupPager = (ViewPager) findViewById(R.id.vp_group_content);
        rcv_group_name = (RecyclerView) findViewById(R.id.rcv_group_name);
        rcv_group_name.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mAdapter = new GroupNameAdapter();
        rcv_group_name.setAdapter(mAdapter);
        setListener();

        /*int top = rcv_group_name.getTop();
        int bottom = rcv_group_name.getBottom();
        Log.d(TAG, "onCreate: -------------height " + (bottom - top));*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        /*int top = rcv_group_name.getTop();
        int bottom = rcv_group_name.getBottom();
        Log.d(TAG, "onStart: --------------top " + top);
        Log.d(TAG, "onStart: --------------bottom " + bottom);
        Log.d(TAG, "onCreate: -------------height " + (bottom - top));*/
        /*//系统识别的最小滑动距离，不同设备之间有差异
        int slop = ViewConfiguration.get(this).getScaledDoubleTapSlop();
        Log.d(TAG, "onStart: --------slop " + slop);*/

        //手势检测 （单击、滑动、长按、双击）
        GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                Log.d(TAG, "onDown: -------------------");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                Log.d(TAG, "onShowPress: ----------------");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.d(TAG, "onSingleTapUp: -----------------");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.d(TAG, "onScroll: ------------------");
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {//长按
                Log.d(TAG, "onLongPress: ------------------");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.d(TAG, "onFling: -------------------");
                return false;
            }
        });
        //解决长按屏幕后无法拖动的现象
        gestureDetector.setIsLongpressEnabled(false);
    }

    private void setListener() {
        mAdapter.setListener(new GroupNameAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d(TAG, "onItemClick: -----------------" + position);
            }
        });
        View childAt = rcv_group_name.getChildAt(0);
//        Log.d(TAG, "setListener: ------------childAt.getWidth() " + childAt.getWidth());

        rcv_group_name.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                View recyclerViewChildAt = recyclerView.getChildAt(newState);
                Log.d(TAG, "onScrollStateChanged: ------recyclerViewChildAt.getWidth() " + recyclerViewChildAt.getWidth());
                Log.d(TAG, "onScrollStateChanged: --------------" + newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d(TAG, "onScrolled: -----------------------" + dx);
            }
        });

        groupPager.setPageMargin(DisplayUtils.dp2px(this, 20));
        groupPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float eventY = event.getY();
                float eventX = event.getX();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //相对于view
                        Log.d(TAG, "setOnTouchListener: -----ACTION_DOWN--y " + event.getY());
                        //相对于屏幕
                        Log.d(TAG, "setOnTouchListener: -----ACTION_DOWN--raw " + event.getRawY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG, "setOnTouchListener: -----ACTION_MOVE--y " + event.getY());
                        Log.d(TAG, "setOnTouchListener: -----ACTION_MOVE--raw " + event.getRawY());
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //计算每秒移动速度
        VelocityTracker velocityTracker = VelocityTracker.obtain();
        velocityTracker.addMovement(event);
        velocityTracker.computeCurrentVelocity(1000);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                Log.d(TAG, "onTouchEvent: -----ACTION_DOWN--y " + event.getY());
//                Log.d(TAG, "onTouchEvent: -----ACTION_DOWN--raw " + event.getRawY());
                break;
            case MotionEvent.ACTION_MOVE:
                float xVelocity = velocityTracker.getXVelocity();
                if (xVelocity > 100) {
                    Log.d(TAG, "onTouchEvent: ----------xVelocity " + xVelocity);
                }

                float yVelocity = velocityTracker.getYVelocity();
                if (yVelocity > 100) {
                    Log.d(TAG, "onTouchEvent: ----------yVelocity" + yVelocity);
                }
                break;
            case MotionEvent.ACTION_UP:
                //不用时清除回收
                velocityTracker.clear();
                velocityTracker.recycle();
                break;
        }
        return false;
    }

    public void moveRcv(View view) {
        tvWorld.scrollBy(10, 10);
    }

    public void gotoTestRxJava(View view) {
        Intent intent = new Intent(this, RxJavaActivity.class);
        startActivity(intent);
    }

    public void toView(View view) {
        startActivity(new Intent(this, ViewActivity.class));
    }

    public void scroll(View view) {
        Intent intent = new Intent(this, ScorllActivity.class);
        startActivity(intent);
    }
}
