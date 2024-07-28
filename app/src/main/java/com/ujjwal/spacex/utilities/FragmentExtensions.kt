package com.ujjwal.spacex.utilities

import android.net.Uri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import timber.log.Timber


fun Fragment.navigate(navDirections: NavDirections) {
    try {
        findNavController().navigate(navDirections)
    } catch (exc: Exception) {
        Timber.e(exc.message)
    }
}

fun Fragment.navigate(uri: Uri) {
    try {
        findNavController().navigate(uri)
    } catch (exc: Exception) {
        Timber.e(exc.message)
    }
}

fun Fragment.navigateBack() {
    try {
        findNavController().navigateUp()
    } catch (exc: Exception) {
        Timber.e(exc.message)
    }
}



