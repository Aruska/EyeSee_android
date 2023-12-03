package org.tensorflow.lite.examples.objectdetection


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import pl.droidsonroids.gif.GifDrawable
import pl.droidsonroids.gif.GifImageView

class IntroActivity : AppCompatActivity() {

    //인트로 시간 설정
    private val delayMillis: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val gifImageView: GifImageView = findViewById(R.id.gifImageView)
        val gifDrawable = GifDrawable(resources, R.drawable.intro)

        gifImageView.setImageDrawable(gifDrawable)

        // Delay for 5 seconds and then navigate to MenuActivity
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToMenuActivity()
        }, delayMillis)
    }

    private fun navigateToMenuActivity() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish() // Optional: Finish the IntroActivity to prevent going back to it
    }
}