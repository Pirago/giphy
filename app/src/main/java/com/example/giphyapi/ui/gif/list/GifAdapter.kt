package com.example.giphyapi.ui.gif.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.giphyapi.R
import com.example.giphyapi.data.Gif
import kotlinx.android.synthetic.main.gif_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class GifAdapter: ListAdapter<Gif, GifAdapter.GifViewHolder>(GifDiffCallback()) {

    var onClick: ((gif: Gif) -> Unit)? = null
    var onLongClick: ((gif: Gif) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder =
        GifViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.gif_item, parent, false))

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        holder.bind(getItem(position), object: OnGifClickListener {
            override fun onItemClick(g: Gif) {
                onClick?.invoke(g)
            }

            override fun onItemLongClick(g: Gif): Boolean {
                onLongClick?.invoke(g)
                return true
            }
        })
    }

    class GifDiffCallback: DiffUtil.ItemCallback<Gif>() {
        override fun areContentsTheSame(oldItem: Gif, newItem: Gif): Boolean = oldItem == newItem
        override fun areItemsTheSame(oldItem: Gif, newItem: Gif): Boolean = oldItem.id == newItem.id
    }

    class GifViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(g: Gif, onGifClickListener: OnGifClickListener) {
            itemView.title.text = g.title
            itemView.username.text = g.username
            //itemView.thumbnail. = g.url
            itemView.root.apply { onClick { onGifClickListener.onItemClick(g) } }
        }
    }

    interface OnGifClickListener {
        fun onItemClick(g: Gif)
        fun onItemLongClick(g: Gif): Boolean
    }
}