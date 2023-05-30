package com.storezaap.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.storezaap.data.BrandCategory
import com.storezaap.data.BrandData
import com.storezaap.data.BrandImageData
import com.storezaap.databinding.BrandImageItemBinding

class BrandImageAdapter constructor(
    private val listener: ImageItemClickListener
) : RecyclerView.Adapter<BrandImageAdapter.ViewHolder>() {

    private val imageList: ArrayList<BrandImageData> = ArrayList()

    fun updateBrandImages(imageList: ArrayList<BrandImageData>){
        var len=this.imageList.size
        this.imageList.clear()
        notifyItemRangeRemoved(0,len)
        len=imageList.size
        this.imageList.addAll(imageList)
        notifyItemRangeInserted(0,len)
    }


    inner class ViewHolder(val binding: BrandImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: BrandImageData) {
            Glide.with(binding.root.context).load(image.image).into(binding.img)
            binding.root.setOnClickListener {
                listener.onImageItemClicked(getBrandCategory(image.image))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            BrandImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    interface ImageItemClickListener {
        fun onImageItemClicked(category: String)
    }

    private fun getBrandCategory(url: String): String {
        var bc = ""
        if (url.contains("amazon")) {
            bc = BrandCategory.AMAZON
        } else if (url.contains("ebay")) {
            bc = BrandCategory.EBAY
        } else if (url.contains("firstcry")) {
            bc = BrandCategory.FIRSTCRY
        } else if (url.contains("flipkart")) {
            bc = BrandCategory.FLIPKART
        } else if (url.contains("infibeam")) {
            bc = BrandCategory.INFIBEAM
        } else if (url.contains("limeroad")) {
            bc = BrandCategory.LIMEROAD
        } else if (url.contains("shopclues")) {
            bc = BrandCategory.SHOPCLUES
        } else if (url.contains("snapdeal")) {
            bc = BrandCategory.SNAPDEAL
        }
        Log.e("BC $url", bc)
        return bc
    }

}