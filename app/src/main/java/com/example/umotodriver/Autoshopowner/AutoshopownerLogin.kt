package com.example.umotodriver.Autoshopowner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.umotodriver.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_autoshopowner_login.*

class AutoshopownerLogin : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autoshopowner_login)

        mAuth = FirebaseAuth.getInstance()

        finalloginAsAutosignUpButton.setOnClickListener {

            var email = finalloginAsAutoEmailId.text
            var password = finalloginAsAutoPassword.text

            if ( !TextUtils.isEmpty(password.toString())){
                loginUser(email.toString(),password.toString())
            }else{
                Toast.makeText(this,"please sir fill every thing ", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun loginUser(email: String, password: String) {

        mAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                    task: Task<AuthResult> ->
                if (task.isSuccessful){

                    startActivity(Intent(this,AutoProfile::class.java))
                }else{
                    Toast.makeText(this,"User Not Created", Toast.LENGTH_LONG).show()
                }

            }

    }
}