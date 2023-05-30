package com.storezaap.ui.home

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.storezaap.data.BrandData
import com.storezaap.databinding.BrandItemBinding

class BrandAdapter : RecyclerView.Adapter<BrandAdapter.ViewHolder>() {

    private val brands: ArrayList<BrandData> = ArrayList()

    fun updateBrand(brands: ArrayList<BrandData>) {
        var len = this.brands.size
        this.brands.clear()
        notifyItemRangeRemoved(0, len)
        len = brands.size
        this.brands.addAll(brands)
        notifyItemRangeInserted(0, len)
    }


    inner class ViewHolder(val binding: BrandItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(brand: BrandData) {
            val context = binding.root.context
            binding.tv.text = brand.text
            Glide.with(context).load(brand.image).into(binding.img)
            binding.root.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(brand.url))
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BrandItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = brands.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(brands[position])
    }

}