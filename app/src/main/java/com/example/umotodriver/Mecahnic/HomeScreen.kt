package com.example.umotodriver.Mecahnic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umotodriver.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreen : AppCompatActivity() {
    private lateinit var auth :FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        auth = FirebaseAuth.getInstance()

        button.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(this,MechanicLogin::class.java))
        }

        button3.setOnClickListener {
            startActivity(Intent(this,MapsActivityfetchmechanic::class.java))

        }
    }
}