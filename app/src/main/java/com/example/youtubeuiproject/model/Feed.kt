package com.example.youtubeuiproject.model

class Feed(var profile:Int, var photo:Int, private var subShorts: List<ShortFeed?>?) {

    fun getSubShorts(): List<ShortFeed?>? {
        return subShorts
    }

    fun setSubShorts(subShorts: List<ShortFeed?>) {
        this.subShorts = subShorts
    }

}