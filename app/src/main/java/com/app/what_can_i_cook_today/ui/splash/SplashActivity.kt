package com.app.what_can_i_cook_today.ui.splash

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.app.what_can_i_cook_today.R
import com.app.what_can_i_cook_today.ui.basenavigation.BaseNavigationActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed(Runnable { startMainActivity() }, 2000)
    }

    private fun startMainActivity() {
        val x = Intent(applicationContext, BaseNavigationActivity::class.java)
        val bndlanimation = ActivityOptions.makeCustomAnimation(
            applicationContext,
            R.transition.cb_fade_in,
            R.transition.cb_face_out
        ).toBundle()
        startActivity(x, bndlanimation)
        finish()
    }
}