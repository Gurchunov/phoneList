package com.example.mobilephonecatalog.data

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.mobilephonecatalog.R

object InitData {
    fun initDevicesList(context: Context): MutableList<ItemMobile> {
        return mutableListOf(
            ItemMobile(
                "Samsung",
                "A50",
                "Android",
                ContextCompat.getDrawable(context, R.drawable.samsung)
            )
        )
    }
}