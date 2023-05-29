package com.storezaap.utils

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


fun AppCompatActivity.makeToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

fun AppCompatActivity.makeToast(@StringRes id: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, id, duration).show()
}

fun Fragment.makeToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), msg, duration).show()
}

fun Fragment.makeToast(@StringRes id: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), id, duration).show()
}

