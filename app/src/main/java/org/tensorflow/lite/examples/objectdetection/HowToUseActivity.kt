package org.tensorflow.lite.examples.objectdetection

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.appcompat.app.AppCompatActivity
import org.tensorflow.lite.examples.objectdetection.R   // Replace with the correct package name
import java.util.Locale

class HowToUseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_howtouse)

        // TTS 초기화
        tts = TextToSpeech(this, this)

    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // 언어 설정
            val result = tts.setLanguage(Locale.KOREAN)

            if (result == TextToSpeech.LANG_MISSING_DATA ||
                result == TextToSpeech.LANG_NOT_SUPPORTED
            ) {
                // 지원하지 않는 언어 또는 데이터가 없는 경우
            } else {
                // TTS 사용 가능한 상태
                val sayTxt = ("안녕하세요, eye see에 오신걸 환영합니다. eye see는 도보 중 위험 요소인 자전거, 킥보드, 오토바이, 신호등 등 물체를 감지하여 음성으로 안내해 드립니다. 기기로 사용자의 상태를 실시간으로 측정하여, 넘어짐, 쓰러짐 등 위험 상황을 인식하고, 긴급상황 발생 시 긴급 연락처로 긴급 문자를 전송합니다").toString()

                speak(sayTxt)
            }
        } else {

        }
    }
    private fun speak(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }
}