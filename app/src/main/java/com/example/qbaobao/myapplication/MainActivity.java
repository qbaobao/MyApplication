package com.example.qbaobao.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn8,minset,cheap;
    private WebView shuffling_web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        shuffling_web = (WebView)findViewById(R.id.first_button);
        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button14);
        btn3 = (Button)findViewById(R.id.button15);
        btn4 = (Button)findViewById(R.id.button16);
        btn5 = (Button)findViewById(R.id.button17);
        btn6 = (Button)findViewById(R.id.button18);
        btn8 = (Button)findViewById(R.id.button20);
        minset = (Button)findViewById(R.id.minesetting1_3);
        cheap = (Button)findViewById(R.id.cheap1_2);
        shuffling_web.getSettings().setJavaScriptEnabled(true);
        shuffling_web.loadUrl("file:///android_asset/lunbo/lunbo.html");
        shuffling_web.getSettings().setSupportZoom(true);
        shuffling_web.getSettings().setBuiltInZoomControls(true);

        // 如果页面中链接，如果希望点击链接继续在当前browser中响应，
        // 而不是新开Android的系统browser中响应该链接，必须覆盖webview的WebViewClient对象
        shuffling_web.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.litreily.Inform1Activity");
                startActivity(i);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.litreily.Manage2Activity");
                startActivity(i);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.litreily.Menu3Activity");
                startActivity(i);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.litreily.Suggest4Activity");
                startActivity(i);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.litreily.Manage5Activity");
                startActivity(i);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 DialogInterface.OnClickListener click1=new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface arg0,int arg1)
                    {
                        Intent in2 = new Intent();
                        in2.setAction(Intent.ACTION_CALL);
                        in2.setData(Uri.parse("tel:1828033985"));
                        startActivity(in2);
                    }
                 };
                DialogInterface.OnClickListener click2=new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface arg0,int arg1)
                    {
                        arg0.cancel();
                    }
                };
                AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(MainActivity.this);
                alertdialogbuilder.setMessage("18280339875");
                alertdialogbuilder.setPositiveButton("确定", click1);
                alertdialogbuilder.setNegativeButton("取消", click2);
                AlertDialog alertdialog1=alertdialogbuilder.create();
                alertdialog1.show();


            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.litreily.Usage8Activity");
                startActivity(i);
            }
        });
        minset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.litreily.MineSettingActivity");
                startActivity(i);
            }
        });
        cheap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.litreily.CheapActivity");
                startActivity(i);
            }
        });

    }

    //go back
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView browser=(WebView)findViewById(R.id.first_button);
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
