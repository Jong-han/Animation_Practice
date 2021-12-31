package com.jh.animation_practice.tween

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.jh.animation_practice.R

class AnimationSetActivity : AppCompatActivity() {

    private val image by lazy { findViewById<ImageView>(R.id.iv_animation_set) }

    private val alpha by lazy { findViewById<Button>(R.id.btn_alpha) }
    private val scale by lazy { findViewById<Button>(R.id.btn_scale) }
    private val translate by lazy { findViewById<Button>(R.id.btn_translate) }
    private val rotate by lazy { findViewById<Button>(R.id.btn_rotate) }
    private val set by lazy { findViewById<Button>(R.id.btn_set)}

    private val alphaAnimation by lazy { AnimationUtils.loadAnimation( this, R.anim.ani_alpha).apply { fillAfter = true } }
    private val scaleAnimation by lazy { AnimationUtils.loadAnimation( this, R.anim.ani_scale).apply { fillAfter = true } }
    private val translateAnimation by lazy { AnimationUtils.loadAnimation( this,
        R.anim.ani_translate
    ).apply { fillAfter = true } }
    private val rotateAnimation by lazy { AnimationUtils.loadAnimation( this, R.anim.anim_rotate).apply { fillAfter = true } }
    private val setAnimation by lazy { AnimationUtils.loadAnimation( this, R.anim.ani_set) }

    private val alphaAnimationListener = object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
            image.startAnimation( scaleAnimation )
        }

        override fun onAnimationRepeat(animation: Animation?) {
        }

    }
    private val scaleAnimationListener = object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
            image.startAnimation(translateAnimation)
        }

        override fun onAnimationRepeat(animation: Animation?) {
        }

    }
    private val translateAnimationListener = object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
            image.startAnimation(rotateAnimation)
        }

        override fun onAnimationRepeat(animation: Animation?) {
        }

    }
    private val rotateAnimationListener = object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
            Toast.makeText(this@AnimationSetActivity, "애니메이션이 모두 종료됨", Toast.LENGTH_SHORT).show()
        }

        override fun onAnimationRepeat(animation: Animation?) {
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_set)

//        setAnimationListener()

        image.setOnClickListener {
            Toast.makeText(this, "이미지 클릭",Toast.LENGTH_SHORT).show()
        }
        alpha.setOnClickListener {
            image.startAnimation( alphaAnimation )
        }
        scale.setOnClickListener {
            image.startAnimation( scaleAnimation )
        }
        translate.setOnClickListener {
            image.startAnimation( translateAnimation )
        }
        rotate.setOnClickListener {
            image.startAnimation( rotateAnimation )
        }
        set.setOnClickListener {
            image.startAnimation( setAnimation )
        }

    }
    fun setAnimationListener() {

        alphaAnimation.setAnimationListener(alphaAnimationListener)
        scaleAnimation.setAnimationListener(scaleAnimationListener)
        translateAnimation.setAnimationListener(translateAnimationListener)
        rotateAnimation.setAnimationListener(rotateAnimationListener)

    }

}