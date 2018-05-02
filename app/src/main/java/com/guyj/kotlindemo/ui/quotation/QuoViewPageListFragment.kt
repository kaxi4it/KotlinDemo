package com.guyj.kotlindemo.ui.quotation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.guyj.AutoLoadMoreAdapter

import com.guyj.kotlindemo.R
import kotlinx.android.synthetic.main.fragment_quo_view_page_list.*
import com.guyj.base.ViewHolder
import com.guyj.kotlindemo.expand.setUpDownColor


/**
 * A simple [Fragment] subclass.
 * Use the [QuoViewPageListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuoViewPageListFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_quo_view_page_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mDatas=ArrayList<String>()
        mDatas.add("12.1")
        mDatas.add("-12.1")
        mDatas.add("12.1")
        mDatas.add("-12.1")
        mDatas.add("0")
        mDatas.add("112.1")
        mDatas.add("-112.1")
        mDatas.add("112.1")
        mDatas.add("-112.1")
        recycler.layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        recycler.isLayoutFrozen=true
        val adapter = object : AutoLoadMoreAdapter<String>(context, R.layout.item_quo_vp_list, mDatas) {
            override fun convert(holder: ViewHolder, s: String, position: Int) {
                val tv_percent=holder.getView<TextView>(R.id.tv_percent)
                tv_percent.text= mDatas[position]
                tv_percent.setUpDownColor()
            }

            override fun loadMore() {
                mDatas.add("33.1")
                mDatas.add("-33.1")
                mDatas.add("3.1")
                mDatas.add("-312.1")
                mDatas.add("0")
                mDatas.add("32.1")
                mDatas.add("-32.1")
                mDatas.add("32.1")
                mDatas.add("-32.1")
            }
        }
        adapter.setAdvanceCount(0)
        recycler.adapter=adapter
        swipe.setOnRefreshListener {
            mDatas.clear()
            mDatas.add("22.1")
            mDatas.add("-212.1")
            mDatas.add("212.1")
            mDatas.add("-212.1")
            mDatas.add("0")
            mDatas.add("212.1")
            mDatas.add("-2112.1")
            mDatas.add("2112.1")
            mDatas.add("-2112.1")
            swipe.isRefreshing=false
        }
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuoViewPageListFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): QuoViewPageListFragment {
            val fragment = QuoViewPageListFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
