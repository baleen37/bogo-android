package com.crewbi.bogo.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import com.crewbi.bogo.Constant
import com.crewbi.bogo.R
import com.crewbi.bogo.widget.webview.BogoWebChromeClient
import com.crewbi.bogo.widget.webview.BogoWebViewClient
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        webview.loadUrl(Constant.URL.BOGO_URL)

        val webSettings = webview.settings
        webSettings.javaScriptEnabled = true

        val bogoWebChromeClient = BogoWebChromeClient()
        webview.webChromeClient = bogoWebChromeClient
        val bogoWebviewClient = BogoWebViewClient(context=this)
        webview.webViewClient = bogoWebviewClient

        swipeRefreshLayout.setOnRefreshListener {
            webview.reload()
        }

        swipeRefreshLayout.isRefreshing = true
        bogoWebviewClient.onloadingListener = object : BogoWebViewClient.OnLoadingListener {
            override fun onFinished(view: WebView?) {
                swipeRefreshLayout.isRefreshing = false
            }
        }
    }

    override fun onBackPressed() {
        if (webview.canGoBack()) {
            return webview.goBack()
        }

        super.onBackPressed()
    }

}
