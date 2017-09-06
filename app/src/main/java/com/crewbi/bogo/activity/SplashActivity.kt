package com.crewbi.bogo.activity

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.crewbi.bogo.Navigator
import com.crewbi.bogo.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Navigator().createMain(context = SplashActivity@ this))
            finish()
        }, 500)
    }
}