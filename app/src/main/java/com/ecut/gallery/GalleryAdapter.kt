package com.ecut.gallery

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.gellery_cell.view.*

class GalleryAdapter:ListAdapter<PhotoItem,MyViewHolder>(DIFFCALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val  holder  = MyViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.gellery_cell,parent,false))
        holder.itemView.setOnClickListener{    }

        return  holder

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.itemView.shimmerLayoutCell.apply {
            setShimmerColor(0x55ffffff)
            setShimmerAngle(0)
            startShimmerAnimation()
        }
        Glide.with(holder.itemView)
            .load(getItem(position).previewUrl)
            .placeholder(R.drawable.ic_photo_size_select_actual_black_24dp)
            .listener(object : RequestListener<Drawable>{
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    return false.also { holder.itemView.shimmerLayoutCell?.stopShimmerAnimation() }
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
            .into(holder.itemView.imageView)
    }

    object DIFFCALLBACK:DiffUtil.ItemCallback<PhotoItem>() {
        override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem.photoId == newItem.photoId
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}
class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)