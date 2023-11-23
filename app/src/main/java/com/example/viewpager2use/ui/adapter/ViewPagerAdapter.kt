package com.example.viewpager2use.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2use.R
import com.example.viewpager2use.data.ViewPagerItems
import com.example.viewpager2use.databinding.ViewpagerScreenBinding
import com.squareup.picasso.Picasso

data class ViewPagerAdapter(var items:List<ViewPagerItems>):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(var binding : ViewpagerScreenBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding : ViewpagerScreenBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.viewpager_screen,parent,false)

        return ViewPagerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val item = items.get(position)
        val h = holder.binding
        Log.e("Dante","Su an adapterdayım")
        Picasso.get()
            .load(item.imageUrl)
            .resize(800,700)
            .into(h.lottieImage)
    }
}