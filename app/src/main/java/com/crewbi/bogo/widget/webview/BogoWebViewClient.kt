package com.crewbi.bogo.widget.webview

import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Created by baleen37@gmail.com on 06/09/2017.
 */
class BogoWebViewClient : WebViewClient() {

    interface OnLoadingListener {
        fun onFinished(view: WebView?)
    }

    public var onloadingListener: OnLoadingListener? = null

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