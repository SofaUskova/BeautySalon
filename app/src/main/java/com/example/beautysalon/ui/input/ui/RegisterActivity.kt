package com.example.beautysalon.ui.input.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.beautysalon.MainActivity
import com.example.beautysalon.R

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initListeners()
    }

    private fun initListeners() {
        findViewById<Button>(R.id.buttonRegister).setOnClickListener {
            //TODO проверить поля на заполненность
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}