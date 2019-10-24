package com.mobimove.voicepayment

import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecognitionListener {


    private val DEBUG = "DEBUG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        speechRecognizer.setRecognitionListener(this)
        val intent = Intent()
        intent.action = RecognizerIntent.ACTION_RECOGNIZE_SPEECH
        val list = mutableListOf("test 1", "test 2", "test 3")
        val arrayAdapter = ArrayAdapter(this, R.layout.item_list, list)

        listView.adapter = arrayAdapter

        btn_record_audio.setOnClickListener {

            if (PermissionUtils.checkAudioPermission(this)) {
                speechRecognizer.startListening(intent)

            } else
                PermissionUtils.makeAudioPermissionRequest(this)
        }

        btnStopRecord.setOnClickListener {
            speechRecognizer.stopListening()
        }

    }

    override fun onReadyForSpeech(params: Bundle?) {
        Log.d(DEBUG, "on speech ready")
    }

    override fun onRmsChanged(rmsdB: Float) {
    }

    override fun onBufferReceived(buffer: ByteArray?) {
        Log.d(DEBUG, "buffer audio ")
    }

    override fun onPartialResults(partialResults: Bundle?) {
        Log.d(DEBUG, "partial audio")

    }

    override fun onEvent(eventType: Int, params: Bundle?) {
        Log.d(DEBUG, "on event ")
    }

    override fun onBeginningOfSpeech() {
        Log.d(DEBUG, "begin to listen audio")
    }

    override fun onEndOfSpeech() {
        Log.d(DEBUG, "begin to listen audio")
    }

    override fun onError(error: Int) {
        Log.d(DEBUG, "error ")
    }

    override fun onResults(results: Bundle?) {
        Log.d(DEBUG, "results are here..")
    }
}
