package com.mobimove.voicepayment

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionUtils{


    companion object {
        const val AUDIO_REQUEST_CODE = 101

        fun checkAudioPermission(context: Activity): Boolean {
            val permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.RECORD_AUDIO
            )
            return permission == PackageManager.PERMISSION_GRANTED
        }


        fun makeAudioPermissionRequest(context: Activity) {
            ActivityCompat.requestPermissions(
                context,
                arrayOf(Manifest.permission.RECORD_AUDIO),
                AUDIO_REQUEST_CODE
            )
        }
    }
}