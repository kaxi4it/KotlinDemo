package com.guyj.kotlindemo.ui.quotation


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.guyj.kotlindemo.R
import kotlinx.android.synthetic.main.fragment_quotation_main.*


/**
 * A simple [Fragment] subclass.
 * Use the [QuotationMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuotationMainFragment : Fragment() {

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
    private var mView:View?=null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.e("QuotationMainFragment","onCreateView")
        return mView?:inflater!!.inflate(R.layout.fragment_quotation_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("QuotationMainFragment","onViewCreated")
        tabLayout.addTab(tabLayout.newTab().setText("CNY市场"))
        tabLayout.addTab(tabLayout.newTab().setText("BTS市场"))
        tabLayout.addTab(tabLayout.newTab().setText("USD市场"))
        tabLayout.addTab(tabLayout.newTab().setText("GDEX.BTC市场"))
        tabLayout.addTab(tabLayout.newTab().setText("SEER市场"))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("QuotationMainFragment","onActivityCreated")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("QuotationMainFragment","onDestroyView")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e("QuotationMainFragment",if (hidden) "hidden" else "show")
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
         * @return A new instance of fragment QuotationMainFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): QuotationMainFragment {
            val fragment = QuotationMainFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
