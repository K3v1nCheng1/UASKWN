package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val loginTextView = findViewById<TextView>(R.id.loginBTN)
        loginTextView.setOnClickListener {// Lakukan tindakan login di sini
        }

        // Find the button by its ID
        val buttonNavigate: Button = findViewById(R.id.signupBTN)

        // Set an OnClickListener on the button
        buttonNavigate.setOnClickListener {
            // Create an Intent to start SecondActivity
            val intent = Intent(this, SignUpPage::class.java)
            startActivity(intent)
        }
    }

}