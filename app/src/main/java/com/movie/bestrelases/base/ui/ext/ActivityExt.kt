package com.movie.bestrelases.base.ui.ext

import com.movie.bestrelases.base.ui.BaseActivity
import com.movie.bestrelases.custom.LoadingProgressDialog.Companion.showLoadingDialog
import com.movie.bestrelases.custom.RetryDialog


fun BaseActivity.hideLoading() {
    if (mProgressDialog != null && mProgressDialog!!.isShowing) {
        mProgressDialog!!.cancel()
    }
}

fun BaseActivity.showLoading() {
    hideLoading()
    mProgressDialog = showLoadingDialog(this)
}

fun BaseActivity.showRetryDialog(retry: Boolean, onRetry: () -> Unit) {
    if (retry) RetryDialog.newInstance(onRetry)
        .show(supportFragmentManager, RetryDialog::class.simpleName)
}