package com.crewbi.bogu.presenter.activity

import android.os.Bundle
import com.crewbi.bogu.Navigator

/**
 * Created by baleen37@gmail.com on 14/09/2017.
 */
class NotificationTunnelActivity : BaseActivity() {

    object EXTRA {
        val url = "url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val url = intent.getStringExtra(EXTRA.url)
        startActivity(Navigator().createMain(this, url = url))
        finish()
    }
}
