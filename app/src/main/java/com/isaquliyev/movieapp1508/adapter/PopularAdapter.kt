package com.isaquliyev.movieapp1508.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isaquliyev.movieapp1508.databinding.PopularLayoutBinding
import com.isaquliyev.movieapp1508.model.PopularItem

class PopularAdapter(private val context: Context, private val itemList: List<PopularItem>):
    RecyclerView.Adapter<PopularAdapter.ItemHolder>() {
    private lateinit var listener: OnItemClickListener

    class ItemHolder(private val binding: PopularLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(item: PopularItem, listener: OnItemClickListener) {
            binding.image.setImageResource(item.image)
            binding.title.text = item.title
            binding.genre.text = item.genre
            binding.rate.text = item.rate

            binding.root.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = PopularLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(itemList[position], listener)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}