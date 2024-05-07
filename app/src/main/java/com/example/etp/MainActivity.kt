package com.example.etp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val qualityInput = findViewById<EditText>(R.id.quality_input)
        val serviceInput = findViewById<EditText>(R.id.service_input)
        val approachInput = findViewById<EditText>(R.id.approach_input)
        val submitButton = findViewById<Button>(R.id.submit_button)
        val averageRatingText = findViewById<TextView>(R.id.average_rating_text)

        submitButton.setOnClickListener {
            val quality = qualityInput.text.toString().toFloatOrNull() ?: 0f
            val service = serviceInput.text.toString().toFloatOrNull() ?: 0f
            val approach = approachInput.text.toString().toFloatOrNull() ?: 0f

            val averageRating = (quality + service + approach) / 3
            averageRatingText.text = "Average Rating: ${String.format("%.2f", averageRating)}"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
