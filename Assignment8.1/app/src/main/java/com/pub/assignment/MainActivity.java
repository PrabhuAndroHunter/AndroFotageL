
package com.pub.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ToggleButton mAscendingBtn, mDescendingBtn;
    private ListView mMonthListview;
    ArrayAdapter myAdapter = null;

    ArrayList<String> monthList_ = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*      create view objects     */
        mAscendingBtn = (ToggleButton) findViewById(R.id.ToggleButton_ascending);
        mDescendingBtn = (ToggleButton) findViewById(R.id.ToggleButton_descending);
        mMonthListview = (ListView) findViewById(R.id.listview_month);
        mMonthListview.setDividerHeight(3);


        /*      Set click event Listener     */
        mAscendingBtn.setOnClickListener(this);
        mDescendingBtn.setOnClickListener(this);

        loadList();     /*     Load data to arraylist     */
        myAdapter = new ArrayAdapter<String>(getBaseContext(), R.layout.simple_text, monthList_);
        mMonthListview.setAdapter(myAdapter); /*    Set adapter to listview     */
    }

    private void loadList() {
        monthList_.clear();
        monthList_.add("A");
        monthList_.add("BB");
        monthList_.add("CCC");
        monthList_.add("DDDD");
        monthList_.add("EEEEE");
        monthList_.add("FFFFFF");
        monthList_.add("GGGGGGG");
        monthList_.add("HHHHHHHH");
        monthList_.add("IIIIIIIIIIIIIIII");
        monthList_.add("JJJJJJJJJJ");
        monthList_.add("KKKKKKKKKKK");
        monthList_.add("LLLLLLLLLLLL");
        monthList_.add("MMMMMMMMMMMMM");
        monthList_.add("NNNNNNNNNNNNNN");
        monthList_.add("OOOOOOOOOOOOOOO");
        monthList_.add("PPPPPPPPPPPPPPPP");
        monthList_.add("QQQQQQQQQQQQQQQQQ");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ToggleButton_ascending: {
                mDescendingBtn.setChecked(false);
                mAscendingBtn.setChecked(true);
                updateList(true);
            }
            break;

            case R.id.ToggleButton_descending:{
                if (mAscendingBtn.isChecked()) {
                    mAscendingBtn.setChecked(false);
                    mDescendingBtn.setChecked(true);
                    updateList(false);
                }
            }
            break;
        }
    }

    private void updateList(boolean ascendingList) {
        if (ascendingList) {
            loadList();
            mMonthListview.setAdapter(myAdapter);
            myAdapter.notifyDataSetChanged();
        } else {
            Collections.sort(monthList_, Collections.reverseOrder());
            mMonthListview.setAdapter(myAdapter);
            myAdapter.notifyDataSetChanged();
        }
    }
}
