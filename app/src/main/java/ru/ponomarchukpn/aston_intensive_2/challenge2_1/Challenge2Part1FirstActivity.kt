package ru.ponomarchukpn.aston_intensive_2.challenge2_1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import ru.ponomarchukpn.aston_intensive_2.R

class Challenge2Part1FirstActivity : AppCompatActivity() {

    private val btnOne by bind<AppCompatButton>(R.id.challenge2_1_btn_one)
    private val btnTwo by bind<AppCompatButton>(R.id.challenge2_1_btn_two)
    private val btnThree by bind<AppCompatButton>(R.id.challenge2_1_btn_three)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge2_1_first)
        setButtonListeners()
    }

    private fun setButtonListeners() {
        btnOne.setOnClickListener {
            val intent = Challenge2Part1SecondActivity.newIntent(
                this,
                Challenge2Part1SecondActivity.MODE_FIRST
            )
            startActivity(intent)
        }
        btnTwo.setOnClickListener {
            val intent = Challenge2Part1SecondActivity.newIntent(
                this,
                Challenge2Part1SecondActivity.MODE_SECOND
            )
            startActivity(intent)
        }
        btnThree.setOnClickListener {
            val intent = Challenge2Part1SecondActivity.newIntent(
                this,
                Challenge2Part1SecondActivity.MODE_THIRD
            )
            startActivity(intent)
        }
    }

    private fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }

    companion object {

        fun newIntent(context: Context) = Intent(context, Challenge2Part1FirstActivity::class.java)
    }
}
