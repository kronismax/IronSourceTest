package com.ironsource.bootcounter.data.notification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.ironSource.bootcounter.R
import com.ironsource.bootcounter.data.db.DatabaseManager
import com.ironsource.bootcounter.presentation.utils.createTextForNotification

class BootNotificationManager {

    @SuppressLint("MissingPermission")
    /*TODO check missing permissions*/
    fun showNotification(context: Context) {

        val records = DatabaseManager(context).getRecords()
        val contentText = records.createTextForNotification()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(context)
        }
        val style = NotificationCompat.BigTextStyle()
        val build = NotificationCompat.Builder(context, CHANNEL_ID)
            .setColor(ContextCompat.getColor(context, R.color.black))
            .setStyle(style)
            .setContentTitle("Boot notification")
            .setContentText(contentText)
            .setOnlyAlertOnce(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()
        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, build)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(context: Context) {
        val channel = NotificationChannel(
            CHANNEL_ID,
            context.getString(R.string.app_name),
            NotificationManager.IMPORTANCE_LOW
        )
        NotificationManagerCompat.from(context).createNotificationChannel(channel)
    }

    companion object {
        private const val CHANNEL_ID = "boot_counter_channel_id"
        private const val NOTIFICATION_ID = 112233
    }
}