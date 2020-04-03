package com.example.firstapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.example.firstapplication.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private int btcCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textCenter);
        textView.onSaveInstanceState();
        textView.setText(String.valueOf(btcCounter));

        // TouchButton btcButton = new TouchButton(findViewById(R.id.button).getContext());
        Button btcButton = findViewById(R.id.button);
        btcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btcCounter++;
                String newString = String.valueOf(btcCounter);
                textView.setText(newString);
            }
        });

//        btcButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                btcCounter++;
//                String newString = String.valueOf(btcCounter);
//                textView.setText(newString);
//            }
//        });


        btcButton.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        return true;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                    // case MotionEvent.ACTION_BUTTON_PRESS:
                    // case MotionEvent.ACTION_BUTTON_RELEASE:
                        // RELEASED
                        return true;
                }
                return false;
            }
        });



//        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
//        ViewPager viewPager = findViewById(R.id.view_pager);
//        viewPager.setAdapter(sectionsPagerAdapter);
//        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);
//        FloatingActionButton fab = findViewById(R.id.fab);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
}