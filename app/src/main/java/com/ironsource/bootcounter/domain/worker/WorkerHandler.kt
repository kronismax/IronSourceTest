package com.ironsource.bootcounter.domain.worker

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import com.ironsource.bootcounter.data.notification.BootNotificationManager
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class WorkerHandler {

    fun scheduleShowNotification(context: Context) {
        val workManager = WorkManager.getInstance(context)
        val showNotificationWork =
            PeriodicWorkRequestBuilder<Worker>(15, TimeUnit.MINUTES).addTag(SHOW_NOTIFICATION)
                .setInitialDelay(0, TimeUnit.SECONDS)
                .build()

        workManager.enqueueUniquePeriodicWork(
            WORK_ID,
            ExistingPeriodicWorkPolicy.REPLACE,
            showNotificationWork
        )
        val work = workManager.getWorkInfosByTag(SHOW_NOTIFICATION)
        val listener = { BootNotificationManager().showNotification(context) }
        work.addListener(listener, Executors.newSingleThreadExecutor())
    }

    companion object {
        const val SHOW_NOTIFICATION = "show_notification"
        const val WORK_ID = "boot_completed_work_id"
    }
}