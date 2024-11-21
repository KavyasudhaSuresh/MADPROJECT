package com.rajkishorbgp.quizapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.rajkishorbgp.quizapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mlModelHelper: MLModelHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the ML Model Helper
        mlModelHelper = MLModelHelper()
        mlModelHelper.loadModel(assets, "quiz_performance_model(1).tflite")

        // Navigate to Quiz Option Activity
        binding.startQuizCard.setOnClickListener {
            evaluatePerformance(1.0f, 2.0f, 120.0f) // Example: inputs for topic, difficulty, time spent
            startActivity(Intent(this@MainActivity, QuizOptionActivity::class.java))
        }

        // Navigate to Rules Activity
        binding.rulesCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, RulesActivity::class.java))
        }

        // Navigate to History Activity
        binding.historyCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, HistoryActivity::class.java))
        }

        // Navigate to Edit Password Activity
        binding.editPasswordCard.setOnClickListener {
            startActivity(Intent(this@MainActivity, EditPasswordActivity::class.java))
        }

        // Log out and navigate to Sign-In Activity
        binding.logoutCard.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Logged out!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    // Use ML model to evaluate quiz readiness or performance prediction
    private fun evaluatePerformance(topic: Float, difficulty: Float, timeSpent: Float) {
        val input = floatArrayOf(topic, difficulty, timeSpent)
        val result = mlModelHelper.runInference(input)

        // Display prediction result (e.g., readiness confidence)
        val confidence = result[0] // Assuming result is a single float value
        val message = "Predicted readiness: ${(confidence * 100).toInt()}%"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release ML resources
        if (::mlModelHelper.isInitialized) {
            mlModelHelper.close()
        }
    }
}
