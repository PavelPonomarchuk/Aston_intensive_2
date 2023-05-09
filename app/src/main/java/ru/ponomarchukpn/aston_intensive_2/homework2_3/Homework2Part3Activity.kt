package ru.ponomarchukpn.aston_intensive_2.homework2_3

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import ru.ponomarchukpn.aston_intensive_2.R

class Homework2Part3Activity : AppCompatActivity() {

    private val btnTakePicture by bind<AppCompatButton>(R.id.homework2_3_btn_take_picture)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework2_3)

        btnTakePicture.setOnClickListener {
            launchCameraApp()
        }
    }

    private fun launchCameraApp() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        try {
            startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            showErrorToast()
        }
    }

    private fun showErrorToast() {
        val message = getString(R.string.homework2_2_error_message)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun <T : Any?> bind(@IdRes idRes: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<View>(idRes) as T }
    }

    companion object {

        fun newIntent(context: Context) = Intent(context, Homework2Part3Activity::class.java)
    }
}
