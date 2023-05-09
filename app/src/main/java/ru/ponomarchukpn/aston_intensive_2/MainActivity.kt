package ru.ponomarchukpn.aston_intensive_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import ru.ponomarchukpn.aston_intensive_2.challenge1_1.ChallengeActivity1Part1
import ru.ponomarchukpn.aston_intensive_2.challenge1_2A.ChallengeActivity1Part2A
import ru.ponomarchukpn.aston_intensive_2.challenge1_2B.ChallengeActivity1Part2B
import ru.ponomarchukpn.aston_intensive_2.challenge1_3.ChallengeActivity1Part3
import ru.ponomarchukpn.aston_intensive_2.challenge2_1.Challenge2Part1FirstActivity
import ru.ponomarchukpn.aston_intensive_2.homework1_1.HomeworkActivity1Part1
import ru.ponomarchukpn.aston_intensive_2.homework1_2B.HomeworkActivity1Part2B
import ru.ponomarchukpn.aston_intensive_2.homework1_3.HomeworkActivity1Part3
import ru.ponomarchukpn.aston_intensive_2.homework1_4.HomeworkActivity1Part4
import ru.ponomarchukpn.aston_intensive_2.homework2_1.Homework2Part1FirstActivity
import ru.ponomarchukpn.aston_intensive_2.homework2_2.Homework2Part2Activity
import ru.ponomarchukpn.aston_intensive_2.homework2_3.Homework2Part3Activity

class MainActivity : AppCompatActivity() {

    private val btnToChallenge1Part1 by bind<Button>(R.id.challenge1_1_btn_show_screen)
    private val btnToHomework1Part1 by bind<Button>(R.id.homework1_1_btn_show_screen)
    private val btnToChallenge1Part2A by bind<Button>(R.id.challenge1_2a_btn_show_screen)
    private val btnToChallenge1Part2B by bind<Button>(R.id.challenge1_2b_btn_show_screen)
    private val btnToHomework1Part2B by bind<Button>(R.id.homework1_2b_btn_show_screen)
    private val btnToChallenge1Part3 by bind<Button>(R.id.challenge1_3_btn_show_screen)
    private val btnToHomework1Part3 by bind<Button>(R.id.homework1_3_btn_show_screen)
    private val btnToHomework1Part4 by bind<Button>(R.id.homework1_4_btn_show_screen)
    private val btnToChallenge2Part1 by bind<Button>(R.id.challenge2_1_btn_show_screen)
    private val btnToHomework2Part1 by bind<Button>(R.id.homework2_1_btn_show_screen)
    private val btnToHomework2Part2 by bind<Button>(R.id.homework2_2_btn_show_screen)
    private val btnToHomework2Part3 by bind<Button>(R.id.homework2_3_btn_show_screen)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        btnToChallenge1Part1.setOnClickListener {
            val intent = ChallengeActivity1Part1.newIntent(this)
            startActivity(intent)
        }
        btnToHomework1Part1.setOnClickListener {
            val intent = HomeworkActivity1Part1.newIntent(this)
            startActivity(intent)
        }
        btnToChallenge1Part2A.setOnClickListener {
            val intent = ChallengeActivity1Part2A.newIntent(this)
            startActivity(intent)
        }
        btnToChallenge1Part2B.setOnClickListener {
            val intent = ChallengeActivity1Part2B.newIntent(this)
            startActivity(intent)
        }
        btnToHomework1Part2B.setOnClickListener {
            val intent = HomeworkActivity1Part2B.newIntent(this)
            startActivity(intent)
        }
        btnToChallenge1Part3.setOnClickListener {
            val intent = ChallengeActivity1Part3.newIntent(this)
            startActivity(intent)
        }
        btnToHomework1Part3.setOnClickListener {
            val intent = HomeworkActivity1Part3.newIntent(this)
            startActivity(intent)
        }
        btnToHomework1Part4.setOnClickListener {
            val intent = HomeworkActivity1Part4.newIntent(this)
            startActivity(intent)
        }
        btnToChallenge2Part1.setOnClickListener {
            val intent = Challenge2Part1FirstActivity.newIntent(this)
            startActivity(intent)
        }
        btnToHomework2Part1.setOnClickListener {
            val intent = Homework2Part1FirstActivity.newIntent(this)
            startActivity(intent)
        }
        btnToHomework2Part2.setOnClickListener {
            val intent = Homework2Part2Activity.newIntent(this)
            startActivity(intent)
        }
        btnToHomework2Part3.setOnClickListener {
            val intent = Homework2Part3Activity.newIntent(this)
            startActivity(intent)
        }
    }

    private fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }
}
