package org.tensorflow.lite.examples.objectdetection

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.Locale




class MenuActivity : AppCompatActivity(), OnInitListener {
    private lateinit var tts: TextToSpeech
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(null)
            setContentView(R.layout.activity_menu)


            val btnDetection : ImageButton  = findViewById(R.id.btnGoToDetection)

            val btnGoToHowToUse : ImageButton  = findViewById(R.id.btnGoToHowToUse)

            //객체인식 화면
            btnDetection.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            //사용방법 화면
            btnGoToHowToUse.setOnClickListener {
                val intent = Intent(this, HowToUseActivity::class.java)
                startActivity(intent)
            }



            // TTS 초기화
            tts = TextToSpeech(this, this)


//            detect_mode.setOnClickListener {
//                val intent = Intent(this@MenuActivity, DetectorActivity::class.java)
//                startActivity(intent)
//            }
//            linclination.setOnClickListener {
//                if (hasPermission()) {
//                    val intent2 = Intent(this@MenuActivity, TestActivity::class.java)
//                    //                    Intent intent2 = new Intent(MenuActivity.this, GyroscopeActivity.class);
//                    startActivity(intent2)
//                } else {
//                    textToSpeech!!.speak(String.format("위치 권한이 허용되지 않았습니다. 위치 권한을 허용하고 다시 시도해주십시요"), TextToSpeech.QUEUE_ADD, null, null)
//                }
//            }
//            if (!hasPermission()) requestPermission()
        }

        //위치 권한 확인
        @RequiresApi(Build.VERSION_CODES.M)
        private fun hasPermission(): Boolean {
            return (checkSelfPermission(org.tensorflow.lite.examples.objectdetection.MenuActivity.Companion.PERMISSION_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(org.tensorflow.lite.examples.objectdetection.MenuActivity.Companion.PERMISSION_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        }

        //위치 권한 요청
        @RequiresApi(Build.VERSION_CODES.M)
        private fun requestPermission() {
            requestPermissions(arrayOf<String>(org.tensorflow.lite.examples.objectdetection.MenuActivity.Companion.PERMISSION_FINE_LOCATION, org.tensorflow.lite.examples.objectdetection.MenuActivity.Companion.PERMISSION_COARSE_LOCATION), org.tensorflow.lite.examples.objectdetection.MenuActivity.Companion.PERMISSIONS_REQUEST)
        }

        companion object {
            private const val PERMISSION_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
            private const val PERMISSION_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION
            private const val PERMISSIONS_REQUEST = 1
        }

    //이동
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // 언어 설정
            val result = tts.setLanguage(Locale.KOREAN)

            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED
            ) {
                // 지원하지 않는 언어 또는 데이터가 없는 경우의 처리
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
    override fun onDestroy() {

        if (::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }
        super.onDestroy()
    }



}
