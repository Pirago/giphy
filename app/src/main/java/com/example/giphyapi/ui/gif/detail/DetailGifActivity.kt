package com.example.giphyapi.ui.gif.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.giphyapi.R
import com.example.giphyapi.data.Gif
import kotlinx.android.synthetic.main.activity_list_gif.*
import kotlinx.android.synthetic.main.gif_item.*

class DetailGifActivity : AppCompatActivity() {
    private val viewModel: DetailGifViewModel by lazy { ViewModelProviders.of(this).get(DetailGifViewModel::class.java) }
    private var gif: Gif? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_gif)

        viewModel.gifId.value = intent.getIntExtra("id", 0)

        viewModel.gif.observe(this, Observer {
                gif = it
                setupToolbar()
                setupViews()
            }
        )
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        title = gif?.title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupViews() {
        gif?.let { gif ->
            title = gif.title
            username.text = gif.username
            // url = gif.url
        }
    }
}
