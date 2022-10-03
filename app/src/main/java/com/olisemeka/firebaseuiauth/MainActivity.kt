package com.olisemeka.firebaseuiauth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.olisemeka.firebaseuiauth.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {}

        val auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null) {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra(USER_ID, auth.currentUser!!.uid)
            startActivity(intent)
        }
    }
        companion object {
            const val USER_ID = "user_id"
        }
}
