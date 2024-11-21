package com.rajkishorbgp.quizapplication

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.rajkishorbgp.quizapplication.databinding.ActivityRulesBinding


class RulesActivity : AppCompatActivity() {
    lateinit var binding: ActivityRulesBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRulesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rulesText.text = (
                "Rules Content:\n" +
                "\n" +
                "1. Welcome to the Quiz App:\n" +
                "   Welcome to the Quiz App! Get ready to test your knowledge and have fun learning. Here's how the quizzes work:\n" +
                "\n" +
                "2. Quiz Mechanics:\n" +
                "   - Each quiz consists of a set of questions related to the selected category.\n" +
                "   - You'll have a limited time to answer each question.\n" +
                "   - Select an answer from the provided options before the timer runs out.\n" +
                "   - Your score is calculated based on the number of correct answers.\n" +
                "\n" +
                "3. Passing Criteria:\n" +
                "   - To pass a quiz, you need to score at least 50%.\n" +
                "   - If you score 50% or higher, you'll receive a passing grade and move on to the next quiz.\n" +
                "\n" +
                "4. Failing and Retaking Quizzes:\n" +
                "   - If you score below 50%, you'll need to retake the quiz to improve your score.\n" +
                "   - Don't worry! Failing a quiz is a chance to learn and try again.\n" +
                "   - You can retake the same quiz as many times as you need to achieve a passing grade.\n" +
                "\n" +
                "5. Category Selection and Difficulty Levels:\n" +
                "   - Choose a quiz category that interests you, such as Math, C Language, or Space Science.\n" +
                "   - Each category offers different sets of questions to challenge your knowledge.\n" +
                "   - You can also select the difficulty level that suits your comfort and expertise.\n" +
                "\n" +
                "6. Tips for Success:\n" +
                "   - Read each question carefully to ensure you understand it.\n" +
                "   - Manage your time wisely to answer as many questions as possible.\n" +
                "   - Don't hesitate to retake quizzes to improve your score and knowledge.\n" +
                "\n" +
                "7. Feedback and Improvement:\n" +
                "   - We value your feedback! If you have suggestions or encounter any issues, let us know.\n" +
                "   - Our goal is to provide an enjoyable and educational experience for you.\n" +
                "\n" +
                "8. Enjoy Learning:\n" +
                "   - Learning is a journey, and quizzes are a fun way to expand your knowledge.\n" +
                "   - Enjoy the process and challenge yourself to become a quiz champion!\n" +
                "\n" +
                "9. Passing Grade Certificate:\n" +
                "   - When you pass a quiz, you'll receive a certificate to celebrate your achievement.\n" +
                "\n" +
                "10. Acknowledgments:\n" +
                "    - We thank you for using the app and wish you the best in your quiz endeavors.\n" +
                "\n" )

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Rules"
        supportActionBar?.title?.let {
            val spannableString = SpannableString(it)
            spannableString.setSpan(StyleSpan(Typeface.BOLD), 0, it.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            supportActionBar?.title = spannableString
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}