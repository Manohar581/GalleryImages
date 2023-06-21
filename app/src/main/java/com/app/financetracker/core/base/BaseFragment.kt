package com.app.financetracker.core.base

import android.widget.Toast
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment(){

    fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}