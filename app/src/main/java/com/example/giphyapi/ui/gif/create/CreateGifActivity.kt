package com.example.giphyapi.ui.gif.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProviders
import com.example.giphyapi.R
import kotlinx.android.synthetic.main.activity_create_gif.*
import kotlinx.android.synthetic.main.activity_list_gif.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CreateGifActivity : AppCompatActivity() {
    private val viewModel: CreateGifViewModel by lazy { ViewModelProviders.of(this).get(CreateGifViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_gif)

        setupToolbar()
        setupFab()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupFab(){
        fabCreate.onClick{
            viewModel.insert()
            ActivityCompat.finishAfterTransition(this@CreateGifActivity)
        }
    }
}