package com.rajkishorbgp.quizapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.rajkishorbgp.quizapplication.databinding.ActivityMathQuizBinding


class MathQuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMathQuizBinding
    private lateinit var list: ArrayList<QuestionManager>
    private var count = 0
    private var score = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMathQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        list = ArrayList()

        // Question
        list.add(QuestionManager("Let Q and R are two finite sets such that n(Q) = 36, n(R) = 40 and n(Q U R) = 50. Find n(Q ∩ R).",
            "25", "26", "27", "None of the above/More than one of the above.", "26"))
        list.add(QuestionManager("If the sum of three consecutive natural numbers is 87, then find the middle number. ",
            "27", "29", "30", "28", "29"))
        list.add(QuestionManager("What should be 25/36 added to to make it −12/18?",
            "-75/108", "-80/108", "-85/108", "-49/36", "-49/36"))
        list.add(QuestionManager("Find the number of zeroes in 10 × 20 × 30 × ... × 1000.",
            "100", "124", "120", "150", "124"))
        list.add(QuestionManager("The sum of three consecutive multiples of 5 is 285. Find the largest number.",
            "75", "100", "120", "90", "100"))
        list.add(QuestionManager("The sum of two numbers is 90. If one of them exceeds the other by 16, find both the numbers?",
            "50, 40", "53, 37", "64, 48","43, 47", "53, 37"))
        list.add(QuestionManager("Rohit multiplies a number by 2 instead of dividing the number by 2. Resultant number is what percentage of the correct value?",
            "200%", "300%", "50%", "400%", "400%"))


        binding.totalQuestion.text = "${list.size}"

        if (list.isNotEmpty()) {
            if (count == 0) {
                binding.question.text = list[0].question
                binding.optionA.text = list[0].optionA
                binding.optionB.text = list[0].optionB
                binding.optionC.text = list[0].optionC
                binding.optionD.text = list[0].optionD
                binding.questionCount.text = "${this.count + 1}."
            }
        }

        binding.optionA.setOnClickListener{
            binding.optionA.text.toString().let { answer ->
                countScore(answer)
            }
        }

        binding.optionB.setOnClickListener{
            binding.optionB.text.toString().let { answer ->
                countScore(answer)
            }
        }

        binding.optionC.setOnClickListener{
            binding.optionC.text.toString().let { answer ->
                countScore(answer)
            }
        }

        binding.optionD.setOnClickListener{
            binding.optionD.text.toString().let { answer ->
                countScore(answer)
            }
        }

        binding.next.setOnClickListener {
            count++
            if (count >= list.size) {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("COUNT", count)
                startActivity(intent)
                finish()
            } else {
                // To clear the selection:
                binding.optionsRadioGroup.clearCheck()
                binding.questionCount.text = "${this.count + 1}."
                binding.question.text = list[count].question
                binding.optionA.text = list[count].optionA
                binding.optionB.text = list[count].optionB
                binding.optionC.text = list[count].optionC
                binding.optionD.text = list[count].optionD
            }
        }
    }

    private fun countScore(i: String) {
        if (count < list.size) {
            if (list[count].answer == i) {
                score++
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}