package com.example.youtubeuiproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeuiproject.R
import com.example.youtubeuiproject.model.Feed
import com.example.youtubeuiproject.model.ShortFeed
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(var context: Context, var items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var TYPE_ITEM_VIEW = 0
    var TYPE_ITEM_LIST = 1


    override fun getItemViewType(position: Int): Int {
        if (items.get(position).getSubShorts() != null) {
            return TYPE_ITEM_LIST
        }
        return TYPE_ITEM_VIEW
    }

    override fun getItemCount(): Int {
        return items.size
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    if (viewType == TYPE_ITEM_LIST) {
        var header = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_list,parent,false)
        return FeedListHolder(header)
    }

        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_video, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val video = items[position]

        if (holder is FeedViewHolder) {
            var iv_profile = holder.iv_profile
            var iv_video = holder.iv_video

            iv_profile.setImageResource(video.profile)
            iv_video.setImageResource(video.photo)
        }

        if (holder is FeedListHolder) {
            var recyclerView :RecyclerView = holder.recyclerView
            recyclerView.setLayoutManager(GridLayoutManager(context,1,GridLayoutManager.HORIZONTAL,false))

            val subShorts: List<ShortFeed?>? = video.getSubShorts()
            refreshSubAdapter(recyclerView, subShorts as ArrayList<ShortFeed>)

        }
    }
    private fun refreshSubAdapter(recyclerView: RecyclerView, shortFeed: ArrayList<ShortFeed>) {
        val adapter: ShortFeedAdapter = ShortFeedAdapter(context, shortFeed)
        recyclerView.adapter = adapter
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var iv_video: ImageView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            iv_video = view.findViewById(R.id.iv_video)
        }
    }

    class FeedListHolder(view: View) : RecyclerView.ViewHolder(view) {

        var recyclerView: RecyclerView = view.findViewById(R.id.recyclerView11)

    }
}

