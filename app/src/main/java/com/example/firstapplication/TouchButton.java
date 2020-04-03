package com.example.firstapplication;

import android.content.Context;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatButton;

public class TouchButton extends Button {


    public TouchButton(Context context) {
        super(context);
    }

    @Override
    public boolean performClick() {
        // do what you want
        return true;
    }
}
