package ru.ponomarchukpn.aston_intensive_2.homework1_3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.ponomarchukpn.aston_intensive_2.R

class HomeworkActivity1Part3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework1_3)
    }

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, HomeworkActivity1Part3::class.java)
        }
    }
}
