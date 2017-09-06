package com.crewbi.bogo.widget.webview

import android.content.Context
import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient


/**
 * Created by baleen37@gmail.com on 06/09/2017.
 */
class BogoWebViewClient(val context: Context) : WebViewClient() {

    interface OnLoadingListener {
        fun onFinished(view: WebView?)
    }

    var onloadingListener: OnLoadingListener? = null

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        val uri = Uri.parse(url)
        if (uri.host.contains("bogo.crewib.com")) {
            return true
        }

        //모르는 URI 이면 chrome tab으로 ㅎ
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(context, Uri.parse(url))

        return true
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        onloadingListener?.onFinished(view)
    }

    override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
        super.onReceivedError(view, errorCode, description, failingUrl)
        onloadingListener?.onFinished(view)
    }

    override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
        super.onReceivedError(view, request, error)
        onloadingListener?.onFinished(view)
    }
}