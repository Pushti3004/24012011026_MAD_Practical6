package com.example.a24012011026_mad_practical6

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var clockAnimation: AnimationDrawable
    lateinit var heartAnimation: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val clockImageview = findViewById<ImageView>(R.id.img1)
        clockImageview.setBackgroundResource(R.drawable.alarm_animation_list)
        clockAnimation = clockImageview.background as AnimationDrawable
        val heartImageView = findViewById<ImageView>(R.id.img2)
        heartImageView.setBackgroundResource(R.drawable.heart_animation_list)
        heartAnimation = findViewById<ImageView>(R.id.img2).background as AnimationDrawable
//
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            clockAnimation.start()
            heartAnimation.start()
        } else {
            clockAnimation.stop()
            heartAnimation.stop()
        }
    }

    override fun onAnimationEnd(animation: Animation?) {

    }

    override fun onAnimationRepeat(animation: Animation?) {

    }

    override fun onAnimationStart(animation: Animation?) {

    }

}