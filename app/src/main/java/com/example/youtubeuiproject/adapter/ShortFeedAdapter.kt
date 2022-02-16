package com.example.youtubeuiproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeuiproject.R
import com.example.youtubeuiproject.model.ShortFeed
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class ShortFeedAdapter(var context: Context, var items:ArrayList<ShortFeed>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_short_video,parent,false)
        return ShortViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val shortVideo = items[position]
        if (holder is ShortViewHolder){
            var tv_title = holder.tv_title
            var tv_views = holder.tv_view
            var iv_profile = holder.iv_profile

            iv_profile.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(shortVideo.profile,0f)
                }
            })

            tv_title.text = shortVideo.tv_title
            tv_views.text = shortVideo.tv_view
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ShortViewHolder(view:View):RecyclerView.ViewHolder(view) {
        var tv_title:TextView
        var tv_view:TextView
        var iv_profile:YouTubePlayerView

        init {
            tv_title = view.findViewById(R.id.tv_short_name)
            tv_view = view.findViewById(R.id.tv_short_views)
            iv_profile = view.findViewById(R.id.vv_video)
        }
    }


}