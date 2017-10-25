package com.winiter.everyutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvLink = (TextView) findViewById(R.id.tv_link);
        String html = getString(R.string.string_of_link);
        CharSequence charSequence = Html.fromHtml(html);
        tvLink.setMovementMethod(LinkMovementMethod.getInstance());
        tvLink.setText(charSequence);
    }
}
