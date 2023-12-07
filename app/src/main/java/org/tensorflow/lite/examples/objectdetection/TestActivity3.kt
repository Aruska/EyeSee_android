package org.tensorflow.lite.examples.objectdetection


import android.app.Dialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import java.util.Locale

class TestActivity3 : AppCompatActivity() {

    private lateinit var broadcastReceiver: BroadcastReceiver
    private lateinit var accelerationTextView: TextView
    private lateinit var gyroscopeTextView: TextView
    private lateinit var dangerFab: View
    private lateinit var handler: Handler
    private lateinit var popupHandler: Handler
    private var tts: TextToSpeech? = null;

    private val delayMillis: Long = 5000 // 5초

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test3)

        // 브로드캐스트 리시버 등록
        registerBroadcastReceiver()

        // UI 요소 초기화
        accelerationTextView = findViewById(R.id.accelerationTextView)
        gyroscopeTextView = findViewById(R.id.gyroscopeTextView)
        dangerFab = findViewById(R.id.dangerFab)

        // 핸들러 초기화
        handler = Handler()

        // 서비스 시작 (이미 시작되어 있다면 이 부분은 생략 가능)
        val serviceIntent = Intent(this, SensorService3::class.java)
        startService(serviceIntent)

        // 위험 FAB 클릭 시 동작
        dangerFab.setOnClickListener {
            // 팝업 창 표시
            showDangerPopup()
        }
    }

    private fun registerBroadcastReceiver() {
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                // 브로드캐스트 수신 시 처리
                when (intent?.action) {
                    "acceleration_data" -> {
                        val x = intent.getFloatExtra("x", 0.0f)
                        val y = intent.getFloatExtra("y", 0.0f)
                        val z = intent.getFloatExtra("z", 0.0f)

                        // UI 업데이트
                        accelerationTextView.text = "Acceleration: x=$x, y=$y, z=$z"
                    }
                    "gyroscope_data" -> {
                        val x = intent.getFloatExtra("x", 0.0f)
                        val y = intent.getFloatExtra("y", 0.0f)
                        val z = intent.getFloatExtra("z", 0.0f)

                        // UI 업데이트
                        gyroscopeTextView.text = "Gyroscope: x=$x, y=$y, z=$z"
                    }
                    "danger_detected" -> {
                        // 팝업 창 표시
                        showDangerPopup()
                    }
                }
            }
        }

        // 브로드캐스트 리시버 등록
        val intentFilter = IntentFilter()
        intentFilter.addAction("acceleration_data")
        intentFilter.addAction("gyroscope_data")
        intentFilter.addAction("danger_detected")
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter)
    }

    fun speak(text: String) {
        tts = TextToSpeech(applicationContext) { status ->
            if (status != Log.ERROR) {
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
        // 브로드캐스트 리시버 등록 해제
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver)
        if (tts != null) { // 사용한 TTS객체 제거
            tts!!.stop()
            tts!!.shutdown()
        }

    }

    private fun showDangerPopup() {
        // Dialog를 사용하여 크기 조절 가능한 팝업 표시
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.activity_pop)

        // 팝업 크기 조절 (원하는 크기로 변경)
        val layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setLayout(layoutParams.width, layoutParams.height)

        // 팝업 내용 설정
        val popupText = dialog.findViewById<TextView>(R.id.popupText)
        popupText.text = "위험 상황 발생"

        // 확인 버튼
        val confirmButton = dialog.findViewById<Button>(R.id.confirmButton)
        confirmButton.setOnClickListener {
            // 사용자가 확인 버튼을 눌렀을 때의 동작
            // 여기에는 팝업을 닫는 등의 동작을 추가할 수 있습니다.
            dialog.dismiss()

            // Service 다시 시작
            val serviceIntent = Intent(this, SensorService3::class.java)
            stopService(serviceIntent)  // Service를 먼저 중지
            startService(serviceIntent) // 다시 시작

            // 타이머 취소
            popupHandler.removeCallbacksAndMessages(null)
        }

        // 팝업 표시
        dialog.show()

        // Handler 초기화 및 10초 타이머 시작
        popupHandler = Handler(Looper.myLooper()!!)
        popupHandler.postDelayed({
            // 10초 동안 사용자가 확인 버튼을 누르지 않으면
            // 여기에 TTS 출력 등의 동작을 추가할 수 있습니다.
            dialog.dismiss()
            speak("안녕")
        }, delayMillis)
    }
}