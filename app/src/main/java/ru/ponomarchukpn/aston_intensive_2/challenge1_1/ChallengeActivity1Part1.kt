package ru.ponomarchukpn.aston_intensive_2.challenge1_1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.ponomarchukpn.aston_intensive_2.R

class ChallengeActivity1Part1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge1_1)

        generateException()
    }

    private fun generateException() {
        try {
            throw RuntimeException("Need to generate, catch and log exception")
        } catch (ex: RuntimeException) {
            Log.e(LOG_TAG, "${ex.javaClass.simpleName} : ${ex.message}")
        }
    }

    companion object {

        private const val LOG_TAG = "Tag_challenge1_1"

        fun newIntent(context: Context): Intent {
            return Intent(context, ChallengeActivity1Part1::class.java)
        }
    }
}
