package com.example.umotodriver.Autoshopowner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umotodriver.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_auto_home_screen.*

class AutoHomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_home_screen)

        button2.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(this,AutoProfile::class.java))
        }
    }
}