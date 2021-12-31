package com.jh.animation_practice.objectanimator

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.Toast
import androidx.core.animation.doOnStart
import com.jh.animation_practice.R

class ObjectAnimatorActivity : AppCompatActivity() {

    private val view by lazy { findViewById<View>(R.id.view) }
    private val button by lazy { findViewById<Button>(R.id.btn_a) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator)

        val colorChangeAnimation = AnimatorInflater.loadAnimator( this, R.animator.object_ani_a)
        colorChangeAnimation.setTarget( view )

        val intervalXAnimation = AnimatorInflater.loadAnimator( this, R.animator.object_ani_interval )
        intervalXAnimation.setTarget( view )

        val intervalXAnimationColorChange = AnimatorInflater.loadAnimator( this, R.animator.object_ani_interval_color_change ).apply {
            duration = 1000
            interpolator = AccelerateDecelerateInterpolator()
            addListener( object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {
                    Toast.makeText( this@ObjectAnimatorActivity, "애니메이션 시작", Toast.LENGTH_SHORT ).show()
                }

                override fun onAnimationEnd(animation: Animator?) {
                    Toast.makeText( this@ObjectAnimatorActivity, "애니메이션 종료", Toast.LENGTH_SHORT ).show()
                }

                override fun onAnimationCancel(animation: Animator?) {
                    Toast.makeText( this@ObjectAnimatorActivity, "애니메이션 취소", Toast.LENGTH_SHORT ).show()
                }

                override fun onAnimationRepeat(animation: Animator?) {
                    Toast.makeText( this@ObjectAnimatorActivity, "애니메이션 시작", Toast.LENGTH_SHORT ).show()
                }
            })
        }

        ObjectAnimator.ofFloat(view, View.TRANSLATION_X, -300f, 300f).apply {
            duration = 500
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
        }.start()

        intervalXAnimationColorChange.setTarget( view )

        val propertyPlaceHolder = AnimatorInflater.loadAnimator( this, R.animator.test )
        propertyPlaceHolder.setTarget( view )

        button.setOnClickListener {
            intervalXAnimationColorChange.start()
        }
        view.setOnClickListener {
            Toast.makeText(this, "클릭", Toast.LENGTH_SHORT).show()
        }

    }
}