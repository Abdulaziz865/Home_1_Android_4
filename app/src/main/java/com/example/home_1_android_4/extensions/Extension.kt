package com.example.home_1_android_4.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(text: String){
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}