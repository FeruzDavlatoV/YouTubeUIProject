package com.example.youtubeuiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeuiproject.adapter.FeedAdapter
import com.example.youtubeuiproject.adapter.FilterAdapter
import com.example.youtubeuiproject.model.Feed
import com.example.youtubeuiproject.model.Filter
import com.example.youtubeuiproject.model.ShortFeed

class MainActivity : AppCompatActivity() {

    lateinit var recyclerFeed: RecyclerView
    lateinit var recyclerFilter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerFilter = findViewById(R.id.recyclerFilter)
        recyclerFilter.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )



        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFeed.setLayoutManager(GridLayoutManager(this, 1))

        refreshStoryAdapter(getAllFilters())
        refreshFeedAdapter(getAllFeeds())

    }

    fun refreshStoryAdapter(chats: ArrayList<Filter>) {
        val adapter = FilterAdapter(this, chats)
        recyclerFilter!!.adapter = adapter
    }



    fun refreshFeedAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerFeed!!.adapter = adapter

    }

    fun getAllFilters():ArrayList<Filter> {
        val filters:ArrayList<Filter> = ArrayList()
        filters.add(Filter("Computer Programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))
        filters.add(Filter("Mobile Development"))
        filters.add(Filter("Mobile Development"))
        return filters
    }


    fun getAllFeeds():ArrayList<Feed> {
        val feed:ArrayList<Feed> = ArrayList()
        feed.add(Feed(R.drawable.my_photo,R.drawable.youtube_1,null))
        feed.add(Feed(R.drawable.my_photo,R.drawable.youtube_1,null))
        feed.add(Feed(R.drawable.my_photo,R.drawable.youtube_1,getAllSubFeeds()))
        feed.add(Feed(R.drawable.my_photo,R.drawable.youtube_1,null))
        feed.add(Feed(R.drawable.my_photo,R.drawable.youtube_1,null))
        return feed
    }

    fun getAllSubFeeds():ArrayList<ShortFeed> {
        val shortFeed :ArrayList<ShortFeed> = ArrayList()
        shortFeed.add(ShortFeed(R.drawable.my_photo,"fsfesfesf","fesfddsfsdf"))
        shortFeed.add(ShortFeed(R.drawable.my_photo,"fsfesfesf","fesfddsfsdf"))
        shortFeed.add(ShortFeed(R.drawable.my_photo,"fsfesfesf","fesfddsfsdf"))
        shortFeed.add(ShortFeed(R.drawable.my_photo,"fsfesfesf","fesfddsfsdf"))
        shortFeed.add(ShortFeed(R.drawable.my_photo,"fsfesfesf","fesfddsfsdf"))
        return shortFeed
    }


}