package com.asrul.technicaltest.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.net.toUri
import com.asrul.technicaltest.R
import com.asrul.technicaltest.ui.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class AppFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        Log.d("waduh", "token: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        sendNotification(message.notification?.title, message.notification?.body, message.data)
    }

    private fun sendNotification(title: String?, messageBody: String?, data: Map<String, String>) {

        val deepLink = (data["deepLink"] ?: "")
            .replace("//", "/")
            .replace(":", "")

        val context = applicationContext

        val deepLinkIntent = Intent(
            Intent.ACTION_VIEW,
            "http://$deepLink".toUri(),
            context,
            MainActivity::class.java
        )

        val deepLinkPendingIntent: PendingIntent? = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(deepLinkIntent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notificationBuilder = NotificationCompat.Builder(
            applicationContext,
            NOTIFICATION_CHANNEL_ID
        )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(messageBody)
            .setContentIntent(deepLinkPendingIntent)
            .setAutoCancel(true)
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationBuilder.setChannelId(NOTIFICATION_CHANNEL_ID)
        notificationManager.createNotificationChannel(channel)
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
    }

    companion object {
        private const val NOTIFICATION_ID = 1
        private const val NOTIFICATION_CHANNEL_ID = "Push Notification"
        private const val NOTIFICATION_CHANNEL_NAME = "Push Notification Firebase"
    }
}