package com.example.beautysalon.ui.input.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.beautysalon.MainActivity
import com.example.beautysalon.R
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initListeners()
    }

    private fun initListeners() {
        findViewById<Button>(R.id.buttonRegister).setOnClickListener {
            if(findViewById<TextInputEditText>(R.id.inputEditTextName).text.isNullOrEmpty() ||
                findViewById<TextInputEditText>(R.id.inputEditTextPhone).text.isNullOrEmpty() ||
                findViewById<TextInputEditText>(R.id.inputEditTextLogin).text.isNullOrEmpty() ||
                findViewById<TextInputEditText>(R.id.inputEditTextPassword).text.isNullOrEmpty()) {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            } else {
                saveData()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    private fun saveData() {
        sharedPreferences = getSharedPreferences("UserPreference", MODE_PRIVATE).edit()
        sharedPreferences.apply {
            putString("NAME", findViewById<TextInputEditText>(R.id.inputEditTextName).text.toString())
            putString("PHONE", findViewById<TextInputEditText>(R.id.inputEditTextPhone).text.toString())
            putString("LOGIN", findViewById<TextInputEditText>(R.id.inputEditTextLogin).text.toString())
        }.apply()
    }
}