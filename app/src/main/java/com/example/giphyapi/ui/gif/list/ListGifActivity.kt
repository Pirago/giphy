package com.example.giphyapi.ui.gif.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.giphyapi.R
import com.example.giphyapi.ui.gif.create.CreateGifActivity
import com.example.giphyapi.ui.gif.detail.DetailGifActivity
import kotlinx.android.synthetic.main.activity_list_gif.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ListGifActivity : AppCompatActivity() {

    private val viewModel: ListGifViewModel by lazy { ViewModelProviders.of(this@ListGifActivity).get(ListGifViewModel::class.java) }
    private var gifAdapter = GifAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_gif)

        setupAdapter()
        setupFab()
        setupRecyclerView()
    }

    private fun setupAdapter() {
        viewModel.gifs.observe(this, Observer {
            gifAdapter.submitList(it)
        })

        gifAdapter.apply {
            onClick = { startActivity(Intent(this@ListGifActivity, DetailGifActivity::class.java).putExtra("id", it.id)) }
        }
    }

    private fun setupFab() {
        fabAdd.onClick { startActivity(Intent(this@ListGifActivity, CreateGifActivity::class.java)) }
    }

    private fun setupRecyclerView() {
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@ListGifActivity, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@ListGifActivity)
            adapter = gifAdapter
        }
    }
}