package com.example.practical6_20012011166

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.practical6_20012011166.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoPlayer()
        val buttonClick = findViewById<FloatingActionButton>(R.id.btnswitch)
        buttonClick.setOnClickListener {
            val intent = Intent(this, YoutubeVideoView::class.java)
            startActivity(intent)
        }
    }
    private fun initVideoPlayer()
    {
        val mediaController = MediaController(this)
        val uri: Uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.thestoryoflight)
        binding.myvideoview.setMediaController(mediaController)
        mediaController.setAnchorView(binding.myvideoview)
        binding.myvideoview.setVideoURI(uri)
        binding.myvideoview.requestFocus()
        binding.myvideoview.start()
    }
}