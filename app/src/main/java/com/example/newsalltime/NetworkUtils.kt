package com.example.newsalltime

import android.content.Context
import android.net.ConnectivityManager


class NetworkUtils {

    companion object {
        fun   isNetworkConnected(context: Context?): Boolean {
            var outcome = false
            if (context != null) {
                val cm = context
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkInfos = cm.allNetworkInfo
                for (tempNetworkInfo in networkInfos) {
                    /**
                     * Can also check if the user is in roaming
                     */
                    if (tempNetworkInfo.isConnected) {
                        outcome = true
                        break
                    }
                }
            }
            return outcome
        }

    }
}

