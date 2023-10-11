package com.example.calorimonitoring

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calorimonitoring.databinding.ActivityWelcomingBinding

class WelcomingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.startButton.setOnClickListener {
            // Ganti TujuanActivity::class.java dengan aktivitas yang sesuai
            val intent = Intent(this, GetStartedActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

