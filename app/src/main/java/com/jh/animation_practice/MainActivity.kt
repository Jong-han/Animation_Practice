package com.jh.animation_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jh.animation_practice.objectanimator.ObjectAnimatorActivity
import com.jh.animation_practice.tween.AnimationSetActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationSetButton = findViewById<Button>(R.id.btn_animation_set)
        val objectAnimatorButton = findViewById<Button>(R.id.btn_object_animator)

        animationSetButton.setOnClickListener {
            startActivity(Intent(this, AnimationSetActivity::class.java))
        }
        objectAnimatorButton.setOnClickListener {
            startActivity(Intent(this, ObjectAnimatorActivity::class.java))
        }

    }
}