package com.something.customcontainer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextSwitcher

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var flag = false

        val switcher = findViewById<TextSwitcher>(R.id.switcher)
        switcher.setFactory { CTextView(baseContext) }
        switcher.setText("Yangsters laid out")
        switcher.outAnimation = AnimationUtils.loadAnimation(baseContext, R.anim.fade_out).apply { duration = 300 }
        switcher.inAnimation = AnimationUtils.loadAnimation(baseContext, R.anim.fade_in).apply { duration = 300 }
        switcher.setOnClickListener {
            if (flag) {
                it as TextSwitcher
                it.setText("Hello World!asfasfasfasfasf asfasfas afsfsafsaf asf 1asfasfasfasfasfasf")
            } else {
                it as TextSwitcher
                switcher.setText("Yangsters laid out")
            }
            flag = !flag
        }
    }
}
