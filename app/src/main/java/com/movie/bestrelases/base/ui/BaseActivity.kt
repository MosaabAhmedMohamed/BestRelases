package com.movie.bestrelases.base.ui

import android.app.ProgressDialog
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity(){

    internal var mProgressDialog: ProgressDialog? = null


}