package ru.ponomarchukpn.aston_intensive_2.homework2_1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import ru.ponomarchukpn.aston_intensive_2.R

class Homework2Part1FirstActivity : AppCompatActivity() {

    private val btnHello by bind<Button>(R.id.homework2_1_btn_hello)
    private val btnCount by bind<Button>(R.id.homework2_1_btn_count)
    private val tvCount by bind<TextView>(R.id.homework2_1_tv_show_count)

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework2_1_first)

        btnHello.setOnClickListener {
            sayHello()
        }
        btnCount.setOnClickListener {
            countUp()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_COUNT, count)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(KEY_COUNT)
        tvCount.text = count.toString()
    }

    private fun sayHello() {
        val intent = Homework2Part1SecondActivity.newIntent(this, count)
        startActivity(intent)
    }

    private fun countUp() {
        count++
        tvCount.text = count.toString()
    }

    private fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }

    companion object {

        private const val KEY_COUNT = "Count"

        fun newIntent(context: Context) = Intent(context, Homework2Part1FirstActivity::class.java)
    }
}
