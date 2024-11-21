package com.rajkishorbgp.quizapplication

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.rajkishorbgp.quizapplication.databinding.ActivityQuizOptionBinding

class QuizOptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizOptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Quiz"
            title?.let {
                val spannableString = SpannableString(it)
                spannableString.setSpan(StyleSpan(Typeface.BOLD), 0, it.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                title = spannableString
            }
        }

        // Start DeepLearningQuizActivity
        binding.deepLearningCardView.setOnClickListener {
            startActivity(Intent(this@QuizOptionActivity, DeepLearningQuizActivity::class.java))
        }

        // Start RLanguageQuizActivity
        binding.rLanguageCardView.setOnClickListener {
            startActivity(Intent(this@QuizOptionActivity, R_Language_Activity::class.java))
        }

        // Start ComputerNetworkQuizActivity
        binding.computerNetworkCardView.setOnClickListener {
            startActivity(Intent(this@QuizOptionActivity, ComputerNetworkActivity::class.java))
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}