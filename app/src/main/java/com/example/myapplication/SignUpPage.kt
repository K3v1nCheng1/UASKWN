package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val yourNameEditText = findViewById<EditText>(R.id.yourname)
        val emailSignInEditText = findViewById<EditText>(R.id.emailsignin)
        val inputPwEditText = findViewById<EditText>(R.id.inputpw)

        clearTextOnFocus(yourNameEditText)
        clearTextOnFocus(emailSignInEditText)
        clearTextOnFocus(inputPwEditText)

        val buttonNavigate: Button = findViewById(R.id.loginBTN)
        buttonNavigate.setOnClickListener {
            val intent = Intent(this, LogInPage::class.java)
            startActivity(intent)
        }
    }
    private fun clearTextOnFocus(editText: EditText) {
        editText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                editText.setTextColor(Color.parseColor("#D9D9D9"))
                editText.hint = ""
            } else {
                when (editText.id) {
                    R.id.yourname -> editText.hint = "Your Name"
                    R.id.emailsignin -> editText.hint = "Enter email"
                    R.id.inputpw -> editText.hint = "Password"
                }
            }
        }
    }


}