package com.example.practical6_20012011166

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import com.example.practical6_20012011166.databinding.ActivityYoutubeVideoViewBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class YoutubeVideoView : AppCompatActivity() {
    private lateinit var binding: ActivityYoutubeVideoViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityYoutubeVideoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initYoutubePlayer()
        val buttonClick = findViewById<FloatingActionButton>(R.id.btnswitch)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private val youtubeId = "SbiCsAcdQ9E"
    @SuppressLint("SetJavaScriptEnabled")
    private fun initYoutubePlayer() {
        val webSettings: WebSettings = binding.youtubeWebView.settings
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        binding.youtubeWebView.loadUrl("https://www.youtube.com/embed/$youtubeId")
    }
}