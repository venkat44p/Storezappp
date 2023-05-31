package com.storezaap.ui.store

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.storezaap.data.store.StoreItem
import com.storezaap.databinding.StoreItemBinding

class StoreAdapter : RecyclerView.Adapter<StoreAdapter.ViewHolder>() {

    private val storeItems: ArrayList<StoreItem> = ArrayList()

    inner class ViewHolder(val binding: StoreItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StoreItem) {
            val context = binding.root.context
            binding.title.text = item.heading
            binding.desc.text = item.desc
            binding.validity.text = item.offer
            binding.btn.text = item.btnText

            Glide.with(context).load(item.image).into(binding.image)

            binding.btn.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.redirectUrl))
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StoreItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = storeItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(storeItems[position])
    }

    fun updateStore(storeItems: ArrayList<StoreItem>) {
        var len = this.storeItems.size
        this.storeItems.clear()
        notifyItemRangeRemoved(0, len)
        len = storeItems.size
        this.storeItems.addAll(storeItems)
        notifyItemRangeInserted(0, len)
    }


}