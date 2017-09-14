package com.crewbi.bogu.presenter.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import com.crewbi.bogu.Constant
import com.crewbi.bogu.R
import com.crewbi.bogu.presenter.webview.BoguWebChromeClient
import com.crewbi.bogu.presenter.webview.BoguWebViewClient
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    object EXTRA {
        val URL = "EXTRA.url"
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        loadData(intent)
    }

    private fun loadData(intent: Intent?) {
        var url = intent?.getStringExtra(EXTRA.URL) ?: ""

        if (url.isEmpty()) {
            url = Constant.URL.BOGU_URL
        }
        webview.loadUrl(url)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupWebView()

        if (savedInstanceState == null) {
            loadData(intent)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        val webSettings = webview.settings
        webSettings.javaScriptEnabled = true

        val bogoWebChromeClient = BoguWebChromeClient()
        webview.webChromeClient = bogoWebChromeClient
        val bogoWebviewClient = BoguWebViewClient(context = this)
        webview.webViewClient = bogoWebviewClient

        swipeRefreshLayout.setOnRefreshListener {
            webview.reload()
        }

        bogoWebviewClient.onloadingListener = object : BoguWebViewClient.OnLoadingListener {
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webview.saveState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        webview.restoreState(savedInstanceState)
    }
}
