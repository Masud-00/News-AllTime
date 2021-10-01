package com.example.newsalltime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.newsalltime.databinding.ActivityMainBinding
import com.example.newsalltime.fragment.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding = DataBindingUtil.setContentView(this,R.layout.activity_main)




   val adapter = PageAdapter(supportFragmentManager)
        adapter.addFragment(GeneralFragment(),"General")
        adapter.addFragment(BusinessFragment(),"Business")
        adapter.addFragment(TechnologyFragment(),"Technology")
        adapter.addFragment(ScienceFragment(),"Science")
     adapter.addFragment(HealthFragment(),"Health")
        adapter.addFragment(EntertainmentFragment(),"Entertainment")
        adapter.addFragment(SportsFragment(),"Sports")
    binding.viewpager.adapter = adapter
        binding.include.setupWithViewPager(binding.viewpager)


    }
    }
