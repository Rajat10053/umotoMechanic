package com.example.umotodriver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umotodriver.Mecahnic.HomeScreen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_splashscreen.*

class Splashscreen : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        iv_note.alpha = 0f
        iv_note.animate().setDuration(2000).alpha(1f).withEndAction {



                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            startActivity(Intent(this,MainActivity::class.java))
            finish()




        }

    }
}