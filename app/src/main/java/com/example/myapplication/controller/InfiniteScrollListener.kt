package com.example.myapplication.controller

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InfiniteScrollListener(private val layoutManager: LinearLayoutManager, val callback: () -> Unit) : RecyclerView.OnScrollListener() {

    private var loading = false
    private var prevItemCount = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy <= 0)  return

        val totalItemCount = layoutManager.itemCount
        val lastItemPosition = layoutManager.findLastVisibleItemPosition() + 1

        if (loading && totalItemCount != prevItemCount) loading = false

        if (!loading && totalItemCount == lastItemPosition) {
            loading = true
            prevItemCount = totalItemCount
            callback()
        }
    }
}
