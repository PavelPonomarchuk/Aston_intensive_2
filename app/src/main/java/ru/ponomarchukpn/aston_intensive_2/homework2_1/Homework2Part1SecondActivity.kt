package ru.ponomarchukpn.aston_intensive_2.homework2_1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import ru.ponomarchukpn.aston_intensive_2.R

class Homework2Part1SecondActivity : AppCompatActivity() {

    private val tvCount by bind<TextView>(R.id.homework2_1_tv_second_count)
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework2_1_second)
        displayCount()
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

    private fun displayCount() {
        val incomingCount = parseIntent()
        tvCount.text = incomingCount.toString()
        count = incomingCount
    }

    private fun parseIntent(): Int {
        if (!intent.hasExtra(EXTRA_COUNT)) {
            throw RuntimeException("$CLASS_NAME : missing extras")
        }
        return intent.getIntExtra(EXTRA_COUNT, 0)
    }

    private fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }

    companion object {

        private val CLASS_NAME = Homework2Part1SecondActivity::class.java.simpleName
        private const val EXTRA_COUNT = "Count"
        private const val KEY_COUNT = "Count"

        fun newIntent(context: Context, count: Int): Intent {
            return Intent(context, Homework2Part1SecondActivity::class.java).apply {
                putExtra(EXTRA_COUNT, count)
            }
        }
    }
}
