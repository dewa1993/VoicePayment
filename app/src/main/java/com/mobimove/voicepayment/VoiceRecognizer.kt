package com.mobimove.voicepayment

import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer

class VoiceRecognizer(private val mContext: Context){
    private val speechRecognizer:SpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(mContext)

    companion object{
        fun getInstance(context: Context): VoiceRecognizer = VoiceRecognizer(context)
    }


    fun startRecognizer(){
        val intent = Intent()
        intent.action = RecognizerIntent.ACTION_RECOGNIZE_SPEECH
    }

}