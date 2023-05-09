package ru.ponomarchukpn.aston_intensive_2.homework1_1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.ponomarchukpn.aston_intensive_2.R

class HomeworkActivity1Part1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework1_1)

        Log.e(LOG_TAG, "Terrible error")
        Log.d(LOG_TAG, "Message for debugging")
        Log.w(LOG_TAG, "Some warning")
        Log.i(LOG_TAG, "Info message")
        Log.v(LOG_TAG, "Some little message with undefined category")
    }

    companion object {

        private const val LOG_TAG = "Tag_homework1_1"

        fun newIntent(context: Context): Intent {
            return Intent(context, HomeworkActivity1Part1::class.java)
        }
    }
}
