package com.bangkit.distromilenial.Activities.Emergency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bangkit.distromilenial.R;
/** By Wibawa Bangkit on Tahun 2020
 *  Aplikasi Distro Milenial
 */
public class TokpedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tokped);

        WebView web=(WebView)findViewById(R.id.webView);
        web.getSettings().setJavaScriptEnabled(true);

        web.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        web.loadUrl("https://www.tokopedia.com/distromileniall");
    }
}