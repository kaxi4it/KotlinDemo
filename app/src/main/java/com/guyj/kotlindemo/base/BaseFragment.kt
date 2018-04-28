package com.guyj.kotlindemo.base

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by gu.yj on 2018/4/28 0028.
 */
abstract class BaseFragment : Fragment() {
    val TAG = this.javaClass.simpleName
    val TAG_PARENT = activity.javaClass.simpleName
    val mContext: Context = activity
    val mActivity: Activity = activity

    var mView : View?=null
    var isLazy: Boolean?=false

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
    }

}