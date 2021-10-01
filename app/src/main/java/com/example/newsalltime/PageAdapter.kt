package com.example.newsalltime

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragmentList: MutableList<Fragment> = ArrayList()
    private val titleList: MutableList<String> = ArrayList()


    override fun getCount(): Int {
        return  titleList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }
    fun addFragment(fragment: Fragment, title: String){
        fragmentList.add(fragment)
        titleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titleList[position]
    }
}



