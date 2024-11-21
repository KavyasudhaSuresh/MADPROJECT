package com.rajkishorbgp.quizapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.rajkishorbgp.quizapplication.databinding.ActivityHistoryBinding
import android.view.MenuItem

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Display the history text
        binding.historyText.text = """
            Welcome, Raj Kishor, to the "History" section of the Quiz App! 
            
            Here's what you can do in this section:
            
            1. Track your quiz history and see a summary of past quizzes.
            2. Analyze your progress and revisit your quizzes to improve.
            3. Set goals to enhance your performance and challenge yourself.
            4. Showcase your achievements with certificates for completed quizzes.
            
            Thank you for being a part of this journey of learning and growth!
        """.trimIndent()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
