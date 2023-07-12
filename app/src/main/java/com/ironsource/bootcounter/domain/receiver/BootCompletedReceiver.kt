package com.ironsource.bootcounter.domain.receiver

import android.Manifest.permission.RECEIVE_BOOT_COMPLETED
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.ironsource.bootcounter.data.db.DatabaseManager
import com.ironsource.bootcounter.domain.worker.WorkerHandler
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BootCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == RECEIVE_BOOT_COMPLETED) {
            runBlocking {
                launch(IO) {
                    DatabaseManager(context).saveBootRecord()
                }
            }
        }
    }
}