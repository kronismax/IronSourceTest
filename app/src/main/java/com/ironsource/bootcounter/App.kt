package com.ironsource.bootcounter

import android.app.Application
import com.ironsource.bootcounter.domain.worker.WorkerHandler

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        WorkerHandler().scheduleShowNotification(this)
    }
}