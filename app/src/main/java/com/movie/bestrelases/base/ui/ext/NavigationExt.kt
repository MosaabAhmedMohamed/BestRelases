package com.movie.bestrelases.base.ui.ext

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


fun Fragment.navigate(action: Int, args: Bundle? = null) {
    findNavController().navigate(action, args)
}