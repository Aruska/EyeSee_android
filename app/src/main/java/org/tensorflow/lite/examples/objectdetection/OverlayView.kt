
package org.tensorflow.lite.examples.objectdetection

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.os.Handler
import android.os.Looper
import android.speech.tts.TextToSpeech
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import java.util.LinkedList
import kotlin.math.max
import org.tensorflow.lite.task.vision.detector.Detection
import java.util.Locale
import java.util.Timer

class OverlayView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var tts: TextToSpeech? = null;
    private var results: List<Detection> = LinkedList<Detection>()
    private var boxPaint = Paint()
    private var textBackgroundPaint = Paint()
    private var textPaint = Paint()
    private var scaleFactor: Float = 1f
    private var lastSpeakTime: Long = 0
    private var bounds = Rect()
    private val speakingTimer = Timer()
    private var isSpeaking: Boolean = false
    init {
        initPaints()
    }

    fun clear() {
        textPaint.reset()
        textBackgroundPaint.reset()
        boxPaint.reset()
        invalidate()
        initPaints()
    }

    private fun initPaints() {
        textBackgroundPaint.color = Color.BLACK
        textBackgroundPaint.style = Paint.Style.FILL
        textBackgroundPaint.textSize = 50f

        textPaint.color = Color.WHITE
        textPaint.style = Paint.Style.FILL
        textPaint.textSize = 50f

        boxPaint.color = ContextCompat.getColor(context!!, R.color.bounding_box_color)
        boxPaint.strokeWidth = 8F
        boxPaint.style = Paint.Style.STROKE
    }

    override fun draw(canvas: Canvas) {
        val currentTime = System.currentTimeMillis()

        // Check if it's been 10 seconds since the last time the TTS spoke
        if (currentTime - lastSpeakTime >= 6000) {
            lastSpeakTime = currentTime
        super.draw(canvas)
        for (result in results) {
            if (result.categories[0].label == "bicycle" || result.categories[0].label == "motorcycle" || result.categories[0].label == "traffic light" || result.categories[0].label == "skateboard") {


//            val isSpeaking = tts!!.isSpeaking
//            if (isSpeaking) {
//                // Wait for 10 seconds
//                Thread.sleep(10000)
//            }

                val boundingBox = result.boundingBox

                val top = boundingBox.top * scaleFactor
                val bottom = boundingBox.bottom * scaleFactor
                val left = boundingBox.left * scaleFactor
                val right = boundingBox.right * scaleFactor

                // Draw bounding box around detected objects
                val drawableRect = RectF(left, top, right, bottom)
                canvas.drawRect(drawableRect, boxPaint)

                // Create text to display alongside detected objects
                val drawableText =
                        result.categories[0].label + " " +
                                String.format("%.2f", result.categories[0].score)

                // Draw rect behind display text
                textBackgroundPaint.getTextBounds(drawableText, 0, drawableText.length, bounds)
                val textWidth = bounds.width()
                val textHeight = bounds.height()
                canvas.drawRect(
                        left,
                        top,
                        left + textWidth + Companion.BOUNDING_RECT_TEXT_PADDING,
                        top + textHeight + Companion.BOUNDING_RECT_TEXT_PADDING,
                        textBackgroundPaint
                )

                // Draw text for detected object
                    val  className = when (result.categories[0].label) {
                        "bicycle" -> "자전거 가"
                        "traffic light" -> "신호등 이"
                        "motorcycle" -> "오토바이 가"
                        "skateboard" -> "전동 킥보드 가"
                        else -> result.categories[0].label
                    }


                    canvas.drawText(drawableText, left, top + bounds.height(), textPaint)
                    val text = ("전방에 "+className + " 있습니다.").toString()
                    tts = TextToSpeech(context) { status ->
                        if (status != Log.ERROR) {
                            val result = tts!!.setLanguage(Locale.KOREA) // 언어 선택
                            tts!!.setSpeechRate(0.9F)
                            if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
                                Log.e("TTS", "This Language is not supported")
                            } else {
                                if (tts!!.isSpeaking == true) {
//                                    val handler = Handler(Looper.getMainLooper())
//                                    val delayedMessage = Runnable {
//                                        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
//                                    }
//                                    handler.postDelayed(delayedMessage, 5000)
//                            tts!!.playSilentUtterance(10000,TextToSpeech.QUEUE_FLUSH,null)
                                }
                                else {
                                    tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
                                }
                            }
                        } else {
                            Log.e("TTS", "Initialization Failed!")
                        }
                    }
                }
                else{}
            }

        }
        else{}
    }

    fun setResults(
            detectionResults: MutableList<Detection>,
            imageHeight: Int,
            imageWidth: Int,
    ) {
        results = detectionResults

        // PreviewView is in FILL_START mode. So we need to scale up the bounding box to match with
        // the size that the captured images will be displayed.
        scaleFactor = max(width * 1f / imageWidth, height * 1f / imageHeight)
    }

    companion object {
        private const val BOUNDING_RECT_TEXT_PADDING = 8
    }
}