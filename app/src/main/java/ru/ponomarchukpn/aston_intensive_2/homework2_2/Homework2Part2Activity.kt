package ru.ponomarchukpn.aston_intensive_2.homework2_2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import ru.ponomarchukpn.aston_intensive_2.R

class Homework2Part2Activity : AppCompatActivity() {

    private val btnCount by bind<AppCompatButton>(R.id.homework2_2_btn_count)
    private val tvCount by bind<TextView>(R.id.homework2_2_tv_count)

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework2_2)
        restoreCounter(savedInstanceState)

        btnCount.setOnClickListener {
            countUp()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_COUNT, count)
        super.onSaveInstanceState(outState)
    }

    private fun restoreCounter(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            count = it.getInt(KEY_COUNT)
            tvCount.text = count.toString()
        }
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

        fun newIntent(context: Context) = Intent(context, Homework2Part2Activity::class.java)
    }
}
