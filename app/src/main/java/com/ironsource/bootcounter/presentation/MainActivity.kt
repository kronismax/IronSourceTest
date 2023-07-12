package com.ironsource.bootcounter.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ironSource.bootcounter.R
import com.ironsource.bootcounter.data.db.DatabaseManager
import com.ironsource.bootcounter.presentation.utils.createTextForUi
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val databaseManager by lazy { DatabaseManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch(IO) {
            val records = databaseManager.getRecords()
            launch(Main) {
                findViewById<TextView>(R.id.tvContent).text = records.createTextForUi()
            }
        }
    }
}