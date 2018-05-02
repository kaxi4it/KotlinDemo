package com.guyj.kotlindemo.expand

import android.annotation.SuppressLint
import android.content.Context
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.widget.TextView
import android.widget.Toast
import com.guyj.kotlindemo.R


/**
 * 作　　者: guyj
 * 修改日期: 2018/4/26
 * 描　　述: 扩展函数类
 * 备　　注:
 */
fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

@SuppressLint("RestrictedApi")
fun BottomNavigationView.setShiftModeDefaultFalse(defaultShiftingMode: Boolean = false) {
    if (defaultShiftingMode) return
    val menuView = this.getChildAt(0) as BottomNavigationMenuView
    try {
        val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
        shiftingMode.isAccessible = true
        shiftingMode.setBoolean(menuView, defaultShiftingMode)
        shiftingMode.isAccessible = false
        for (i in 0 until menuView.childCount) {
            val item = menuView.getChildAt(i) as BottomNavigationItemView
            item.setShiftingMode(defaultShiftingMode)
            item.setChecked(item.itemData.isChecked)
        }
    } catch (e: NoSuchFieldException) {
        e.printStackTrace()
    } catch (e: IllegalAccessException) {
        e.printStackTrace()
    }
}

fun TextView.setUpDownColor() {
    try {
        val textNum = this.text.toString().toDouble()
            when {
                textNum > 0 -> {
                    this.append("%↑")
                    this.background = resources.getDrawable(R.drawable.shape_tv_cornor_green)
                }
                textNum == 0.0 -> {
                    this.append("%")
                    this.background = resources.getDrawable(R.drawable.shape_tv_cornor_grey)
                }
                else -> {
                    this.append("%↓")
                    this.background = resources.getDrawable(R.drawable.shape_tv_cornor_red)
                }
            }
    } catch (e: NumberFormatException) {
        return
    }
}
