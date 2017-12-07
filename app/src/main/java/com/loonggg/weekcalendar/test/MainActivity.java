package com.loonggg.weekcalendar.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.loonggg.weekcalendar.view.WeekCalendar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar mToolbar;
    TextView mTvTitle;//标题
    WeekCalendar weekCalendar;//自定义日历控件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weekCalendar = (WeekCalendar) findViewById(R.id.week_calendar);
        List<String> list = new ArrayList<>();
        list.add("2017-12-13");
        list.add("2017-12-11");
        list.add("2017-12-10");
        list.add("2017-12-16");
        weekCalendar.setSelectDates(list);
        //设置日历点击事件
        weekCalendar.setOnDateClickListener(new WeekCalendar.OnDateClickListener() {
            @Override
            public void onDateClick(String time) {
                Toast.makeText(MainActivity.this, weekCalendar.getTheDayOfSelected(), Toast.LENGTH_SHORT).show();
            }
        });

        weekCalendar.setOnCurrentMonthDateListener(new WeekCalendar.OnCurrentMonthDateListener() {
            @Override
            public void onCallbackMonthDate(String year, String month) {
                Toast.makeText(MainActivity.this, year + "-" + month, Toast.LENGTH_SHORT).show();
            }
        });

        weekCalendar.showSomeDay(2016,2,01);
        Toast.makeText(MainActivity.this, weekCalendar.getTheDayOfSelected(), Toast.LENGTH_SHORT).show();




    }
}
