package com.example.qbaobao.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MineSetting_my_propertyActivity extends AppCompatActivity {

    private WebView mysetting_web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_mine_setting_my_property);
        mysetting_web = (WebView) findViewById(R.id.activity_mine_setting_my_property_web);
        mysetting_web.getSettings().setJavaScriptEnabled(true);
        mysetting_web.loadUrl("file:///android_asset/webPage/myProperty.html");

        // 如果页面中链接，如果希望点击链接继续在当前browser中响应，
        // 而不是新开Android的系统browser中响应该链接，必须覆盖webview的WebViewClient对象
        mysetting_web.setWebViewClient(new WebViewClient() {
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
        WebView browser=(WebView)findViewById(R.id.activity_mine_setting_my_property_web);
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
