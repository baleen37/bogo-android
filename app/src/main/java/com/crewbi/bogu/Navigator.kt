package com.crewbi.bogu

import android.content.Context
import android.content.Intent
import com.crewbi.bogu.presenter.activity.MainActivity

/**
 * Created by baleen37@gmail.com on 06/09/2017.
 */
class Navigator {
    fun createMain(context: Context, url: String? = ""): Intent {
        return Intent(context, MainActivity::class.java)
                .putExtra(MainActivity.EXTRA.URL, url)
    }
}
