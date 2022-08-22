package com.ferin.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String getIntentString;
    TextView intentTextView;
    WebView YtWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intentTextView = findViewById(R.id.textView);
        YtWebView = findViewById(R.id.webView);

        // Displays the Text from the editView which passed using Intent
        getIntentString = getIntent().getStringExtra("IntentText");
        intentTextView.setText(getIntentString);


        // Embeds and plays Youtube video in webView
        String videoStr = "<html><body>YouTube Video<br><br><iframe width=\"320\" height=\"220\" src=\"https://www.youtube.com/embed/Cv7CJg8pSIM\n\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        YtWebView.loadData(videoStr,"text/html", "utf-8");
        YtWebView.getSettings().setJavaScriptEnabled(true);


    }
}


//        https://utreon.com/embed/IjGE6WrLQFm
//        https://www.youtube.com/embed/Cv7CJg8pSIM     // Test Links