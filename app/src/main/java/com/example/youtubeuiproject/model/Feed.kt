package com.example.youtubeuiproject.model

class Feed(var profile:String, var video:String, private var subShorts: List<ShortFeed?>?) {

    fun getSubShorts(): List<ShortFeed?>? {
        return subShorts
    }

    fun setSubShorts(subShorts: List<ShortFeed?>) {
        this.subShorts = subShorts
    }

}