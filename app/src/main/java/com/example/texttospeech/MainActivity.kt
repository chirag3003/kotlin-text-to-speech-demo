package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import com.example.texttospeech.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech;
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tts = TextToSpeech(this, this)

        binding.btnSpeak.setOnClickListener{
            tts.speak("Text To Speech Demo", TextToSpeech.QUEUE_FLUSH,null,"")

        }
    }

    override fun onInit(p0: Int) {

    }

    override fun onDestroy() {
        super.onDestroy()

        tts.stop()
        tts.shutdown()

    }
}