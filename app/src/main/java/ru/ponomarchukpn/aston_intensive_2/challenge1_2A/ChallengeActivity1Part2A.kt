package ru.ponomarchukpn.aston_intensive_2.challenge1_2A

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import ru.ponomarchukpn.aston_intensive_2.R

class ChallengeActivity1Part2A : AppCompatActivity() {

    private val btnToast by bind<Button>(R.id.challenge1_2a_btn_toast)
    private val btnCount by bind<Button>(R.id.challenge1_2a_btn_count)
    private val tvCount by bind<TextView>(R.id.challenge1_2a_tv_show_count)

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge1_2a)

        btnToast.setOnClickListener {
            showToast()
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

    private fun showToast() {
        val messageIdRes = R.string.challenge1_2a_toast_message
        Toast.makeText(this, messageIdRes, Toast.LENGTH_SHORT).show()
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

        fun newIntent(context: Context): Intent {
            return Intent(context, ChallengeActivity1Part2A::class.java)
        }
    }
}
