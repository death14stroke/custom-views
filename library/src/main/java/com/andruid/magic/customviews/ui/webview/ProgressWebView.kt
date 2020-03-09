package com.andruid.magic.customviews.ui.webview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.core.content.res.getResourceIdOrThrow
import com.andruid.magic.customviews.R

/**
 * WebView with a progressBar that shows progress while the web page is loading
 */
class ProgressWebView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {
    // progressBar
    private lateinit var progressBar: ProgressBar

    // progressBar ID
    private var progressBarID: Int

    init {
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.ProgressWebView, defStyleAttr, 0
        )
        progressBarID = a.getResourceIdOrThrow(R.styleable.ProgressWebView_progressBar)
        a.recycle()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        progressBar = (parent as View).findViewById(progressBarID)
        webChromeClient = ProgressWebChromeClient(progressBar)
    }
}