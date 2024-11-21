package com.rajkishorbgp.quizapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log // Added for debugging
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.rajkishorbgp.quizapplication.databinding.ActivityScoreBinding
import nl.dionsegijn.konfetti.models.Shape.Circle
import nl.dionsegijn.konfetti.models.Shape.Square
import nl.dionsegijn.konfetti.models.Size

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Get score and total count from intent
        val score = intent.getIntExtra("SCORE", -1)
        val total = intent.getIntExtra("COUNT", -1)

        Log.d("ScoreActivity", "Received SCORE: $score, COUNT: $total") // Debug log

        if (score == -1 || total == -1) {
            // If score or total is missing, handle gracefully
            binding.score.text = "Error: Invalid data received."
            binding.secondaryScore.text = ""
            binding.isWinner.text = "Please try again."
            return
        }

        // Display the score
        binding.score.text = "Congratulations! Your score is $score"
        binding.secondaryScore.text = "$score/$total"

        if (score > total / 2) {
            binding.isWinner.text = "You Passed!"
            binding.viewKonfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Square, Circle)
                .addSizes(Size(12, 5f))
                .setPosition(-50f, binding.viewKonfetti.width + 50f, -50f, -50f)
                .streamFor(300, 5000L)
        } else {
            binding.isWinner.text = "You Failed. Pass by scoring more than ${total / 2}."
        }

        // Retry button
        binding.tryAgain.setOnClickListener {
            startActivity(Intent(this, QuizOptionActivity::class.java)) // Navigate back to Quiz options
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
