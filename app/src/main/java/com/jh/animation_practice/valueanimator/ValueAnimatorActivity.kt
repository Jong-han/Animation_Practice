package com.jh.animation_practice.valueanimator

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnStart
import com.jh.animation_practice.R

class ValueAnimatorActivity : AppCompatActivity() {

    private val view: View by lazy { findViewById(R.id.view_value_animator) }

    private val targetHeight = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator)

        val valueAnimator = ValueAnimator.ofInt(view.height, targetHeight).apply {
            addUpdateListener {
                view.layoutParams = view.layoutParams.also { params ->
                    params.height = it.animatedValue as Int
                }
            }
            duration = 10000
            interpolator = AccelerateDecelerateInterpolator()
            doOnStart {
                Toast.makeText(this@ValueAnimatorActivity,"Start Value Animator",Toast.LENGTH_SHORT).show()
            }
        }
        valueAnimator.start()
    }
}