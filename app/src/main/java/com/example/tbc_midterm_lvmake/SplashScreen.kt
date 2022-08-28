package com.example.tbc_midterm_lvmake

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import java.util.*
import kotlin.concurrent.schedule

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
        val intent = Intent(this, MainActivity::class.java)
        val hiAnimation: LottieAnimationView = findViewById(R.id.hi)
        val heartAnimation: LottieAnimationView = findViewById(R.id.heart)
        val meditationAnimation: LottieAnimationView = findViewById(R.id.meditation)

        hiAnimation.animate().translationY(-2200f).setDuration(1000).startDelay = 4000
        heartAnimation.animate().translationX(2200f).setDuration(1000).startDelay = 4000
        meditationAnimation.animate().translationX(-2200f).setDuration(1000).startDelay = 4000

        Timer().schedule(6000) {
            startActivity(intent)
            finish()
        }

    }

}