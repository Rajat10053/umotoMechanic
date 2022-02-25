package com.example.umotodriver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umotodriver.Autoshopowner.AutoHomeScreen
import com.example.umotodriver.Autoshopowner.AutoshopownerLogin
import com.example.umotodriver.Mecahnic.HomeScreen
import com.example.umotodriver.Mecahnic.MechanicLogin
import com.example.umotodriver.Mecahnic.profilepage
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        loginAsMechanicButton.setOnClickListener {
            if(user != null){

                startActivity(Intent(this, HomeScreen::class.java))

                finish()

            }else{val i = Intent(this,MechanicLogin::class.java)
                startActivity(i)

                finish()}
        }

        loginAsAutomobileShopownerButton.setOnClickListener {
            if(user != null){

                startActivity(Intent(this, AutoHomeScreen::class.java))

                finish()

            }else{val i = Intent(this,AutoshopownerLogin::class.java)
                startActivity(i)

                finish()}
        }
    }
}