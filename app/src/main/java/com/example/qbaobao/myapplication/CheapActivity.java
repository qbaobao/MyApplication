package com.example.qbaobao.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class CheapActivity extends AppCompatActivity {

    private WebView cheap_web;
    Button backPage2_1,minesetting2_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cheap);

        backPage2_1 = (Button)findViewById(R.id.backPage2_1);
        minesetting2_3 = (Button)findViewById(R.id.minesetting2_3);
        backPage2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheapActivity.this.finish();
            }
        });
        minesetting2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.litreily.MineSettingActivity");
                startActivity(i);
                CheapActivity.this.finish();
            }
        });

        cheap_web = (WebView) findViewById(R.id.activity_cheap_web);
        cheap_web.getSettings().setJavaScriptEnabled(true);
        cheap_web.loadUrl("file:///android_asset/webPage/store.html");

        // 如果页面中链接，如果希望点击链接继续在当前browser中响应，
        // 而不是新开Android的系统browser中响应该链接，必须覆盖webview的WebViewClient对象
        cheap_web.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });
    }

    //go back
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView browser=(WebView)findViewById(R.id.activity_cheap_web);
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && browser.canGoBack()) {
            browser.goBack();
            return true;
        }
        //  return true;
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
