package com.example.firstapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;
import androidx.constraintlayout.widget.ConstraintLayout;
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

        // изменение видимости (visible, invisible, gone)
        // textView.setVisibility(View.VISIBLE);

        // TouchButton btcButton = new TouchButton(findViewById(R.id.button).getContext());
        Button btcButton = findViewById(R.id.button);
        btcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btcCounter++;

                // запуск второг окна при условии кратности
                if (btcCounter % 5 == 0)
                    secondActivity();


                if (btcCounter % 3 == 0)
                    set();

                String newString = String.valueOf(btcCounter);
                textView.setText(newString);
            }
        });
    }



    /** add element from code
     * можно добавлять элементы не через xml а через код, может работать чуть быстрее
     * */
    private void set(){
        RelativeLayout layout  = findViewById(R.id.relative);

        TextView tx = new TextView(this);
        tx.setText("from text");

        LinearLayout.LayoutParams linearLayout = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        linearLayout.gravity = Gravity.CENTER_HORIZONTAL;
        tx.setLayoutParams(linearLayout);

        layout.addView(tx);
    }


    // логирование если приложение было свернуто
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("AppLog", "App paused");
    }

    // логирование когда вернулись к приложению
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("AppLog", "App resumed");
    }
    // таким же образом можно логировать onStop, onStart, onDestroy(хотя он врядли выполнится, лучше использовать ниже)

    // запускается при креше приложения, в отличии от обычных исключений
    // Thread.UncaughtExceptionHandler;

    private void secondActivity(){
        // запуск статичного метода для открытия второго активити
        SecondActivity.start(this, btcCounter);
    }
}