package com.zeynepaslierhan.photosharing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser
        if(user!=null){
            val usermail = user.email.toString()
            Toast.makeText(this,"Welcome: ${usermail}",Toast.LENGTH_LONG).show()

            val intent =Intent(this,FeedActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun register(view: View){

        val email = EmailText.text.toString()
        val password = PasswordText.text.toString()

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task->
            if(task.isSuccessful){
                val intent = Intent(this,FeedActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener{exception->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }

    }

    fun login(view:View){

        val email = EmailText.text.toString()
        val password = PasswordText.text.toString()

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task->
            if(task.isSuccessful){

                val user = auth.currentUser?.email.toString()

                Toast.makeText(this,"Welcome: ${user}",Toast.LENGTH_LONG).show()

                val intent =Intent(this,FeedActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener{exception->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }

    }
}