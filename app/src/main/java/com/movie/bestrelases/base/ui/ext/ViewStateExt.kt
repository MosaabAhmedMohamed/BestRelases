package com.movie.bestrelases.base.ui.ext

import androidx.fragment.app.Fragment
import com.movie.bestrelases.base.ui.BaseActivity
import com.movie.bestrelases.custom.RetryDialog

fun Fragment.showLoading(visibility: Boolean) {
    if (visibility) (requireActivity() as BaseActivity).showLoading()
    else (requireActivity() as BaseActivity).hideLoading()
}

fun Fragment.showRetryDialog(retry: Boolean, onRetry: () -> Unit) {
    if (retry) RetryDialog.newInstance(onRetry)
        .show(childFragmentManager, RetryDialog::class.simpleName)
}