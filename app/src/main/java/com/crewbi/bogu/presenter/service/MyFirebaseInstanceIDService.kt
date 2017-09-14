package com.crewbi.bogu.presenter.service

import android.util.Log
import com.crewbi.bogu.App
import com.crewbi.bogu.domain.source.repository.UserRepository
import com.crewbi.bogu.util.Installation
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import javax.inject.Inject

class MyFirebaseInstanceIDService : FirebaseInstanceIdService() {

    @Inject
    lateinit var userRepository: UserRepository

    companion object {
        private val TAG = "MyFirebaseIIDService"
    }

    init {
        App.graph.inject(this)
    }


    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    override fun onTokenRefresh() {
        // Get updated InstanceID token.
        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d(TAG, "Refreshed token: " + refreshedToken!!)

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        val uuid = Installation.id(context = this)
        sendRegistrationToServer(uuid = uuid, token = refreshedToken)
    }
    // [END refresh_token]

    /**
     * Persist token to third-party servers.
     *
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private fun sendRegistrationToServer(uuid: String?, token: String?) {
        uuid?.let {
            token?.let {
                userRepository.registerPushToken(uuid = uuid, token = token)
                        .subscribe({ t ->
                            Log.d(TAG, "success")
                        }, { e ->
                            Log.e(TAG, "failure", e)
                        })
            }
        }
    }
}