package com.jh.animation_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jh.animation_practice.objectanimator.ObjectAnimatorActivity
import com.jh.animation_practice.tween.AnimationSetActivity
import com.jh.animation_practice.valueanimator.ValueAnimatorActivity
import com.jh.animation_practice.vectordrawable.VectorDrawableActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationSetButton = findViewById<Button>(R.id.btn_animation_set)
        val objectAnimatorButton = findViewById<Button>(R.id.btn_object_animator)
        val valueAnimatorButton = findViewById<Button>(R.id.btn_value_animator)
        val animatedVectorDrawable = findViewById<Button>(R.id.btn_animated_vector_drawable)

        animationSetButton.setOnClickListener {
            startActivity(Intent(this, AnimationSetActivity::class.java))
        }
        objectAnimatorButton.setOnClickListener {
            startActivity(Intent(this, ObjectAnimatorActivity::class.java))
        }
        valueAnimatorButton.setOnClickListener {
            startActivity(Intent(this, ValueAnimatorActivity::class.java))
        }
        animatedVectorDrawable.setOnClickListener {
            startActivity(Intent(this, VectorDrawableActivity::class.java))
        }

    }
}