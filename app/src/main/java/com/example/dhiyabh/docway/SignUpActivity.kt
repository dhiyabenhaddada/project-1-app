package com.example.dhiyabh.docway

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signin.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        auth = FirebaseAuth.getInstance()


        b.setOnClickListener{
            signUpUser()
        }
    }
    private fun signUpUser() {


        if ((Patterns.EMAIL_ADDRESS.matcher(et1.text.toString()).matches())&&(!e2.text.toString().isEmpty())) {


            auth.createUserWithEmailAndPassword(et1.text.toString(), e2.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(baseContext, "Sign Up failed. Try again after some time.",
                                    Toast.LENGTH_SHORT).show()
                        }

                    }
        } else {

            Toast.makeText(baseContext, "Please verify your email or your password.",
                    Toast.LENGTH_SHORT).show()

        }
    }}




