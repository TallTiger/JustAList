package com.example.scott.justalist;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_relative);
    }

    public void addThing(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow((null==getCurrentFocus()) ?
                null : getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        EditText editText = (EditText) findViewById(R.id.newItem);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.listLinearLayout);
        TextView textView = new TextView(this);
        textView.setText(editText.getText().toString());
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 200);
        linearLayout.addView(textView);
        editText.setText("");

        clearScreen(view);
    }

    public void clearScreen(View view) {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int widthScreen = size.x;
        int heightScreen = size.y;
        Log.d("SIZE", "The width is " + widthScreen);
        Log.d("Size", "The height is " + heightScreen);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.listLinearLayout);
        int widthList = linearLayout.getMeasuredWidth();
        int heightList = linearLayout.getMeasuredHeight();
        Log.d("Size", "The width is " + widthList);
        Log.d("Size", "The height is " + heightList);

        if (heightList > 1200) {
            linearLayout.removeView(linearLayout.getChildAt(0));
        }
    }
}
