package com.guyj.kotlindemo.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.ArrayList

/**
 * Created by gu.yj on 2018/5/7 0007.
 */
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var mFragmentList: List<Fragment>? = null
    private var mPageTitle: List<String>? = null

    fun setFragments(fragments: ArrayList<Fragment>) {
        mFragmentList = fragments
    }

    fun setPageTitle(titles: ArrayList<String>) {
        mPageTitle = titles
    }

    override fun getItem(position: Int): Fragment {

        return mFragmentList!![position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mPageTitle!![position]
    }

    override fun getCount(): Int {

        return mFragmentList!!.size
    }
}