package ru.ponomarchukpn.aston_intensive_2.homework1_2B

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import ru.ponomarchukpn.aston_intensive_2.R

class HomeworkActivity1Part2B : AppCompatActivity() {

    private val btnToast by bind<Button>(R.id.homework1_2b_btn_toast)
    private val btnCount by bind<Button>(R.id.homework1_2b_btn_count)
    private val btnZero by bind<Button>(R.id.homework1_2b_btn_zero)
    private val tvCount by bind<TextView>(R.id.homework1_2b_tv_show_count)

    private var count: Int = 0
    private var countColorId = R.color.purple_700
    private var zeroColorId = R.color.homework1_2b_bg_gray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework1_2b)
        setButtonListeners()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_COUNT, count)
        outState.putInt(KEY_COUNT_COLOR_ID, countColorId)
        outState.putInt(KEY_ZERO_COLOR_ID, zeroColorId)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(KEY_COUNT)
        tvCount.text = count.toString()

        val countColor = savedInstanceState.getInt(KEY_COUNT_COLOR_ID)
        btnCount.setBackgroundColor(getColor(countColor))
        countColorId = countColor

        val zeroColor = savedInstanceState.getInt(KEY_ZERO_COLOR_ID)
        btnZero.setBackgroundColor(getColor(zeroColor))
        zeroColorId = zeroColor
    }

    private fun setButtonListeners() {
        btnToast.setOnClickListener {
            showToast()
        }
        btnCount.setOnClickListener {
            countUp()
            setButtonCountColor()
            setButtonZeroColor()
        }
        btnZero.setOnClickListener {
            resetCount()
        }
    }

    private fun showToast() {
        val messageIdRes = R.string.challenge1_2a_toast_message
        Toast.makeText(this, messageIdRes, Toast.LENGTH_SHORT).show()
    }

    private fun countUp() {
        count++
        tvCount.text = count.toString()
    }

    private fun setButtonCountColor() {
        val colorId = if (count % 2 == 0) {
            R.color.teal_700
        } else {
            R.color.purple_700
        }
        btnCount.setBackgroundColor(getColor(colorId))
        countColorId = colorId
    }

    private fun setButtonZeroColor() {
        if (count > 0) {
            btnZero.setBackgroundColor(getColor(R.color.purple_700))
            zeroColorId = R.color.purple_700
        }
    }

    private fun resetCount() {
        count = 0
        tvCount.text = count.toString()
        btnCount.setBackgroundColor(getColor(R.color.purple_700))
        countColorId = R.color.purple_700
        btnZero.setBackgroundColor(getColor(R.color.homework1_2b_bg_gray))
        zeroColorId = R.color.homework1_2b_bg_gray
    }

    private fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }

    companion object {

        private const val KEY_COUNT = "Count"
        private const val KEY_COUNT_COLOR_ID = "Count_color_id"
        private const val KEY_ZERO_COLOR_ID = "Zero_color_id"

        fun newIntent(context: Context): Intent {
            return Intent(context, HomeworkActivity1Part2B::class.java)
        }
    }
}
