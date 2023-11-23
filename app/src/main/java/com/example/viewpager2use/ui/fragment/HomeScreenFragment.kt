package com.example.viewpager2use.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.viewpager2use.R
import com.example.viewpager2use.data.ViewPagerItems
import com.example.viewpager2use.databinding.FragmentHomeScreenBinding
import com.example.viewpager2use.ui.adapter.ViewPagerAdapter

class HomeScreenFragment : Fragment() {


    private lateinit var binding : FragmentHomeScreenBinding
    private lateinit var adapter : ViewPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_home_screen, container, false)

        binding.objectHomePageFragment = this
        val itemList = ArrayList<ViewPagerItems>()
        val i1 = ViewPagerItems("deneme1","deneme2","https://c.biztoc.com/p/dfa1c374b6a496d1/s.webp")
        val i2 = ViewPagerItems("deneme1","deneme2","https://image.cnbcfm.com/api/v1/image/107338017-17006712872023-11-22t154054z_1820884796_rc2bi4a13tzl_rtrmadp_0_usa-thanksgiving-travel.jpeg?v=1700700260&w=1920&h=1080")
        itemList.add(i1)
        itemList.add(i2)
        Log.e("Dante","HomeFragment is runned")

        adapter = ViewPagerAdapter(itemList)

        binding.myAdapter = adapter



        return binding.root
    }

}