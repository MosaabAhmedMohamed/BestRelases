package com.movie.bestrelases.util

import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

object FirebaseAnalyticsUtil {

    private var firebaseAnalytics = Firebase.analytics

    fun logMovieDetailEvent(id: Int, name: String) {
        val prams = Bundle().apply {
            putString(FirebaseAnalytics.Param.ITEM_ID, id.toString())
            putString(FirebaseAnalytics.Param.ITEM_NAME, name)
        }
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, prams)
    }

}