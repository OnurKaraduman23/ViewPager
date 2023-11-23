package com.example.viewpager2use.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
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
        setViewPagerItems()
        setupIndicators()
        setCurrentIndicator(0)


        return binding.root
    }



    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(adapter.itemCount)
        val layoutParams : LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(requireContext())
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams = layoutParams
                binding.indicatorsContainer.addView(it)
            }
        }

    }

    private fun setCurrentIndicator(position : Int) {
        val childCount = binding.indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView = binding.indicatorsContainer.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator_active_background
                    )
                )
            }else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }
    fun setViewPagerItems(){
        binding.ViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
    }





}