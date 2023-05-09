package ru.ponomarchukpn.aston_intensive_2.challenge2_1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import ru.ponomarchukpn.aston_intensive_2.R

class Challenge2Part1SecondActivity : AppCompatActivity() {

    private val tvContent by bind<TextView>(R.id.challenge2_1_tv_content)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge2_1_second)
        displayText()
    }

    private fun displayText() {
        val text = when(parseIntent()) {
            MODE_FIRST -> resources.getString(R.string.challenge2_1_text_one)
            MODE_SECOND -> resources.getString(R.string.challenge2_1_text_two)
            MODE_THIRD -> resources.getString(R.string.challenge2_1_text_three)
            else -> {
                throw RuntimeException("$CLASS_NAME : unknown mode")
            }
        }
        tvContent.text = text
    }

    private fun parseIntent(): Int {
        if (!intent.hasExtra(EXTRA_MODE)) {
            throw RuntimeException("$CLASS_NAME : missing extras")
        }
        return intent.getIntExtra(EXTRA_MODE, 0)
    }

    private fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }

    companion object {

        private val CLASS_NAME = Challenge2Part1SecondActivity::class.java.simpleName
        private const val EXTRA_MODE = "Second_activity_mode"
        const val MODE_FIRST = 0
        const val MODE_SECOND = 1
        const val MODE_THIRD = 2

        fun newIntent(context: Context, mode: Int): Intent {
            if (mode != MODE_FIRST && mode != MODE_SECOND && mode != MODE_THIRD) {
                throw RuntimeException("Unknown mode: $mode in $CLASS_NAME")
            }
            return Intent(context, Challenge2Part1SecondActivity::class.java).apply {
                putExtra(EXTRA_MODE, mode)
            }
        }
    }
}
