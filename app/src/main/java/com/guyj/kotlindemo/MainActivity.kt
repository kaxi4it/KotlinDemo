package com.guyj.kotlindemo

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.guyj.kotlindemo.expand.setShiftMode
import com.guyj.kotlindemo.ui.quotation.QuotationMainFragment
import com.guyj.kotlindemo.ui.setting.SettingFragment
import com.guyj.kotlindemo.ui.transaction.TransactionFragment
import com.guyj.kotlindemo.ui.wallet.WalletMainFragment
import com.squareup.leakcanary.LeakCanary
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_quotation -> {
                itemChange(item.itemId,0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_wallet -> {
                itemChange(item.itemId,1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_transaction -> {
                itemChange(item.itemId,0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_setting -> {
                itemChange(item.itemId,1)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private val quotationMainFragment = QuotationMainFragment.newInstance("","")
    private val walletMainFragment = WalletMainFragment.newInstance("","")
    private val transactionFragment = TransactionFragment.newInstance("","")
    private val settingFragment = SettingFragment.newInstance("","")
    private val fragments = listOf(quotationMainFragment, walletMainFragment,transactionFragment,settingFragment)
    private var lastMenuItemId :Int?=null
    private var lastFragment :Fragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LeakCanary.install(application)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.setShiftMode()
        supportFragmentManager.beginTransaction().add(R.id.main_content, fragments[0]).commit()
        lastFragment = fragments[0]
        lastMenuItemId = R.id.navigation_quotation
    }

    private fun itemChange(menuItemId:Int?,position:Int=0){
        if (lastMenuItemId != menuItemId) {
            val transaction :FragmentTransaction=supportFragmentManager.beginTransaction()
            if (fragments[position].isAdded) {
                transaction.hide(lastFragment).show(fragments[position]).commit()
            } else {
                transaction.hide(lastFragment).add(R.id.main_content, fragments[position]).commit()
            }
            lastFragment = fragments[position]
            lastMenuItemId = menuItemId
        }

    }


}
