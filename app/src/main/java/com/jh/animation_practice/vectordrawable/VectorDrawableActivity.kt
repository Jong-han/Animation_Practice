package com.jh.animation_practice.vectordrawable

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.jh.animation_practice.R

class VectorDrawableActivity : AppCompatActivity() {

    private val image by lazy { findViewById<ImageView>(R.id.vector_img) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vector_drawable)

        image.setOnClickListener {

            if ( image.tag == null ) {
                image.setImageResource(R.drawable.h_to_z)
                (image.drawable as AnimatedVectorDrawable).start()
                image.tag = 1
            } else {
                image.setImageResource(R.drawable.z_to_h)
                (image.drawable as AnimatedVectorDrawable).start()
                image.tag = null
            }

        }

    }
}