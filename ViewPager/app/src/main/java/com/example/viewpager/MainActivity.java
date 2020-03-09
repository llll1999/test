package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<View> alist = new ArrayList<>();
    private View view_one,view_two,view_three,view_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        view_one = View.inflate(this,R.layout.activity_1,null);
        view_two = View.inflate(this,R.layout.activity_2,null);
        view_three = View.inflate(this,R.layout.activity_3,null);
        view_four = View.inflate(this,R.layout.activity_4,null);
        alist.add(view_one);
        alist.add(view_two);
        alist.add(view_three);
        alist.add(view_four);
        viewPager.setAdapter(new myPagerAdapter());
    }

    private class myPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return alist.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(alist.get(position));
            return alist.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(alist.get(position));
        }
    }
}
