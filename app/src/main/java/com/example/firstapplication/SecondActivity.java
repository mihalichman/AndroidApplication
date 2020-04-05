package com.example.firstapplication;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    private static final String KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // берем значение из переданного Intent
        int btcCount = getIntent().getIntExtra(KEY, 0);

        Log.i("SecondAct10", "init");

        // берем вью и присуждаем ему значение переданное из intent
        TextView statusText = findViewById(R.id.textViewSecondAct);
        statusText.setText(getString(R.string.secondActText, btcCount));
    }

    public static void start(Activity activity, int btcCount){
        // создаем интент
        Intent intent = new Intent(activity, SecondActivity.class);

        // добавляем данные в интент
        intent.putExtra(KEY, btcCount);

        // запуск активити
        activity.startActivity(intent);
    }
}
