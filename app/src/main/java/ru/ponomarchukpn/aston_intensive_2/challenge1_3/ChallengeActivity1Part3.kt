package ru.ponomarchukpn.aston_intensive_2.challenge1_3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.ponomarchukpn.aston_intensive_2.R

class ChallengeActivity1Part3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge1_3)
    }

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, ChallengeActivity1Part3::class.java)
        }
    }
}
