package com.rajkishorbgp.quizapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.rajkishorbgp.quizapplication.databinding.ActivityMathQuizBinding
import com.rajkishorbgp.quizapplication.databinding.ActivitySpaceScienceBinding


class SpaceScienceActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpaceScienceBinding
    private lateinit var list: ArrayList<QuestionManager>
    private var count = 0
    private var score = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpaceScienceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.title="Math"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        list = ArrayList()

        // Question
        list.add(QuestionManager("What do most asteroids orbit?",
            "the Sun", "Earth", "Pluto", "None of the above", "the Sun"))
        list.add(QuestionManager("Which of these contain large quantities of ice?",
            "stars", "comets", "asteroids", "None of the above", "comets"))
        list.add(QuestionManager("Which of the following is not a scientific optical instrument?",
            "periscope", "microscope", "telescope", "endoscope", "periscope"))
        list.add(QuestionManager("What astronomer suggested that the Sun was at the center of the solar system?",
            "Ptolemy", "Theon of Alexandria", "Copernicus", "Hypatia", "Copernicus"))
        list.add(QuestionManager("Which astronomer wrote the Aryabhatiya?",
            "Aryabhata I", "Galileo", "Brahmagupta", "Bhaskara I", "Aryabhata I"))

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
        if (item.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}