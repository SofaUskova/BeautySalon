package com.example.beautysalon.ui.input.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.beautysalon.MainActivity
import com.example.beautysalon.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initListeners()
    }

    private fun initListeners() {
        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            if (!findViewById<TextInputEditText>(R.id.inputEditTextLogin).text.isNullOrEmpty()
                && !findViewById<TextInputEditText>(R.id.inputEditTextPassword).text.isNullOrEmpty()) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()            }
        }

        findViewById<Button>(R.id.buttonRegister).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }
}