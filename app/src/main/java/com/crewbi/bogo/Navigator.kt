package com.crewbi.bogo

import android.content.Context
import android.content.Intent
import com.crewbi.bogo.activity.MainActivity

/**
 * Created by baleen37@gmail.com on 06/09/2017.
 */
class Navigator {
    fun createMain(context: Context): Intent {
        return Intent(context, MainActivity::class.java)
    }
}
