package com.example.musica

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var Bplay:Button
    private lateinit var Bpause:Button
    private lateinit var MPlayer:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Radio La Ranchera"

        Bplay = findViewById<Button>(R.id.buttonPlay)
        Bpause = findViewById<Button>(R.id.buttonPause)

        LaRanchera()
    }

    private fun LaRanchera(){

        var url = "https://ranchera.stream.laut.fm/ranchera?ref=radiode&t302=2022-08-05_09-47-15&uuid=894bba3e-1935-4830-8141-f804768c8113"


        MPlayer = MediaPlayer()
        MPlayer.setDataSource(url)
        MPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        MPlayer.prepareAsync()

        MPlayer.setOnPreparedListener {
            Play(this)
        }
    }

    private fun Play(context: Context){
        Bplay.setOnClickListener  {
            MPlayer.start()
            Toast.makeText(context, "En Play...", Toast.LENGTH_SHORT).show()
        }

        Bpause.setOnClickListener {
            MPlayer.pause()
            Toast.makeText(context, "En Pause...", Toast.LENGTH_SHORT).show()
        }
    }
}