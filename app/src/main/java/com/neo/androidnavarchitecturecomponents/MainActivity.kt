package com.neo.androidnavarchitecturecomponents

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavDeepLinkBuilder


/**
 * Host Activity in nav graph
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendFakeNotification()
    }

    private fun sendFakeNotification() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel0", "name", importance)
            notificationManager.createNotificationChannel(channel)
        }

        // args to be passed to the boatFragment
        var args = BoatFragmentArgs.Builder(2).build().toBundle()

        // creates pendingIntent using nav arch DeepLink Builder
        val pendingIntent = NavDeepLinkBuilder(applicationContext)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.boatFragment)
            .setArguments(args)
            .createPendingIntent()

        val notification = Notification.Builder(applicationContext)
            .setContentTitle("Now on sale")
            .setAutoCancel(true)
            .setSmallIcon(R.drawable.speed_boat_blue)
            .setContentIntent(pendingIntent)
            .setChannelId("channel0")


//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            notification.setChannelId("chanel0")
//        }
        notificationManager.notify(0, notification.build())
    }
}