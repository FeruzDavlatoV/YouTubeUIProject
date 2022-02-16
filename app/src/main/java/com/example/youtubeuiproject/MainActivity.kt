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
        feed.add(Feed("https://yt3.ggpht.com/LLoRVw7onB5Bw-rSb5OXerG2Moj4S8Q56_bqs3fDu2dYZxr2EyRymHN6ybyUp9uzb4GlfMlu8A=s88-c-k-c0x00ffffff-no-rj","2aFBf7Qt6L0",null))
        feed.add(Feed("https://yt3.ggpht.com/E81KY7SAPat3qrUuc1N7cztfr8QABJ0f3CUlOF_gQkH7cKP1K8lxaFyp8w3732goS4-pj5KhJpk=s88-c-k-c0x00ffffff-no-rj","MQIAKvjPwus",getAllSubFeeds()))
        feed.add(Feed("https://yt3.ggpht.com/pl-pa9hLg5NS2sXUlKsvpDwoinfjlKzYb8cM0zqGVxUUBDeRbGegGZbC8QRcPj62yiFzYN70Lg=s88-c-k-c0x00ffffff-no-rj","I7P3zMCPVLQ",null))
        feed.add(Feed("https://yt3.ggpht.com/ytc/AKedOLQ01YVhDOp8uanTDAcSLvEmHoRNzj9ONYu488UiRg=s88-c-k-c0x00ffffff-no-rj","yi0OYUMqvAw",null))
        return feed
    }

    fun getAllSubFeeds():ArrayList<ShortFeed> {
        val shortFeed :ArrayList<ShortFeed> = ArrayList()
        shortFeed.add(ShortFeed("C76Nz35RCAw","RecyclerView inside recyclerView","1,3 mln view"))
        shortFeed.add(ShortFeed("PYGmABsIChA","Sabr tagi sariq oltin","1,2 mln view"))
        shortFeed.add(ShortFeed("C76Nz35RCAw","c","1,3 mln view"))
        shortFeed.add(ShortFeed("PYGmABsIChA","Sabr tagi sariq oltin","1,2 mln view"))
        shortFeed.add(ShortFeed("C76Nz35RCAw","RecyclerView inside recyclerView ","1,3 mln view"))
        shortFeed.add(ShortFeed("PYGmABsIChA","Sabr tagi sariq oltin","1,2 mln view"))
        return shortFeed
    }


}