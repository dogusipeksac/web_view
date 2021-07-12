package com.example.web_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText editTextUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.webView);
        webView.setWebViewClient(new myWebView());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_INSET);
        editTextUrl=findViewById(R.id.enterEditTextId);
        webView.loadUrl("https://github.com/dogusipeksac");
    }
    String url;
    public void goButton(View view) {
        loadUrl(editTextUrl.getText().toString());
    }

    public void backButton(View view) {
        webView.goBack();
    }

    public void forwardButton(View view) {
        webView.goForward();
    }

    void loadUrl(String url){
        this.url=url;
        webView.loadUrl(url);
    }
    private class myWebView extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
            view.loadUrl(url);
            return true;
        }
    }
}