package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogInPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log_in_page)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginTextView = findViewById<TextView>(R.id.registerBTN)
        loginTextView.setOnClickListener {
            // Lakukan tindakan login di sini
        }

        val yourEmailEditText = findViewById<EditText>(R.id.email)
        val passInputInEditText = findViewById<EditText>(R.id.input)

        clearTextOnFocus(yourEmailEditText)
        clearTextOnFocus(passInputInEditText)
    }

    private fun clearTextOnFocus(editText: EditText) {
        editText.onFocusChangeListener = object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if (hasFocus) {
                    editText.setTextColor(Color.parseColor("#D9D9D9"))
                    editText.hint = "   "
                } else {
                    when (editText.id) {
                        R.id.email -> editText.hint = "   Enter your email here"
                        R.id.input -> editText.hint = "   Password"
                    }
                }
            }
        }
    }
}
