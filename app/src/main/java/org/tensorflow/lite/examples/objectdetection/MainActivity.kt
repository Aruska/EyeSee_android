
package org.tensorflow.lite.examples.objectdetection

import android.content.Intent
import android.graphics.RectF
import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.util.Log.ERROR
import androidx.appcompat.app.AppCompatActivity
import org.tensorflow.lite.examples.objectdetection.databinding.ActivityMainBinding
import org.tensorflow.lite.task.vision.detector.Detection
import java.util.LinkedList
import java.util.Locale

/**
 * Main entry point into our app. This app follows the single-activity pattern, and all
 * functionality is implemented in the form of fragments.
 */
class MainActivity : AppCompatActivity() {
    private var tts: TextToSpeech? = null;
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        speak("객체인식 모드로 진입합니다.");
    }

    override fun onBackPressed() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
            // Workaround for Android Q memory leak issue in IRequestFinishCallback$Stub.
            // (https://issuetracker.google.com/issues/139738913)
            finishAfterTransition()
        } else {
            super.onBackPressed()
        }
    }

    fun speak(text: String) {
        tts = TextToSpeech(applicationContext) { status ->
            if (status != ERROR) {
                val result = tts!!.setLanguage(Locale.KOREA) // 언어 선택
                tts!!.setSpeechRate(1F)
                if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
                    Log.e("TTS", "This Language is not supported")
                } else {
                    tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
                }
            } else {
                Log.e("TTS", "Initialization Failed!")
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        if (tts != null) { // 사용한 TTS객체 제거
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }


}
