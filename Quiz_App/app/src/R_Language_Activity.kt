package com.rajkishorbgp.quizapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.rajkishorbgp.quizapplication.databinding.ActivityRlanguageBinding

class R_Language_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityRlanguageBinding
    private lateinit var list: ArrayList<QuestionManager>
    private var count = 0
    private var score = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRlanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        list = ArrayList()

        // R Language Questions
        list.add(QuestionManager("What is the purpose of data management?",
            "To store data", "To organize, maintain, and retrieve data efficiently", "To visualize data", "To delete unnecessary data", "To organize, maintain, and retrieve data efficiently"))
        list.add(QuestionManager("Which function is used for console input in R?",
            "read()", "scan()", "input()", "readline()", "readline()"))
        list.add(QuestionManager("What is the primary data structure in R for storing sequences of data?",
            "Factor", "Vector", "Matrix", "List", "Vector"))
        list.add(QuestionManager("Which operator is used for assignment in R?",
            "=", "<-", "->", "==", "<-"))
        list.add(QuestionManager("Which data type in R can store both numeric and character values?",
            "List", "Vector", "Factor", "Data Frame", "Data Frame"))
        list.add(QuestionManager("What is the default data type in R when entering numeric values without decimals?",
            "Integer", "Double", "Logical", "Character", "Integer"))
        list.add(QuestionManager("Which function is used to create a vector in R?",
            "vector()", "create_vector()", "c()", "new_vector()", "c()"))
        list.add(QuestionManager("What is a data frame in R?",
            "A table-like structure that holds data in rows and columns", "A one-dimensional array", "A function in R", "A numeric data type", "A table-like structure that holds data in rows and columns"))
        list.add(QuestionManager("Which R function is used to get the structure of a data frame?",
            "structure()", "str()", "summary()", "info()", "str()"))
        list.add(QuestionManager("Which operator is used for logical 'AND' in R?",
            "&", "|", "&&", "||", "&"))
        list.add(QuestionManager("How are functions created in R?",
            "Using the function() keyword", "Using def keyword", "Using create() keyword", "Using define() keyword", "Using the function() keyword"))
        list.add(QuestionManager("Which data structure in R is used for categorical data?",
            "Vector", "Factor", "Matrix", "List", "Factor"))
        list.add(QuestionManager("What is the use of the table() function in R?",
            "To create a data frame", "To summarize categorical data", "To visualize data", "To create a list", "To summarize categorical data"))
        list.add(QuestionManager("How can you import a CSV file in R?",
            "read.csv()", "import.csv()", "load.csv()", "open.csv()", "read.csv()"))
        list.add(QuestionManager("Which R function is used to export data to a CSV file?",
            "save.csv()", "export.csv()", "write.csv()", "send.csv()", "write.csv()"))
        list.add(QuestionManager("Which data structure in R is two-dimensional and homogeneous?",
            "Vector", "Data frame", "Matrix", "List", "Matrix"))
        list.add(QuestionManager("What is the use of str() function in R?",
            "To create strings", "To display structure of an object", "To format text output", "To summarize data", "To display structure of an object"))
        list.add(QuestionManager("What is the main use of visualization in data analysis?",
            "To simplify data storage", "To communicate insights effectively", "To manipulate data", "To reduce data redundancy", "To communicate insights effectively"))
        list.add(QuestionManager("Which R function is used for plotting data?",
            "plot()", "chart()", "graph()", "visualize()", "plot()"))
        list.add(QuestionManager("What type of variable is used to store names or labels in R?",
            "Character", "Factor", "Numeric", "Logical", "Character"))
        list.add(QuestionManager("How can you create a matrix in R?",
            "matrix()", "create_matrix()", "mtx()", "make_matrix()", "matrix()"))
        list.add(QuestionManager("What is the purpose of summary() function in R?",
            "To display a summary of an R object", "To create a plot", "To concatenate vectors", "To change data type", "To display a summary of an R object"))
        list.add(QuestionManager("What is a list in R?",
            "A one-dimensional array", "A data structure that can contain different data types", "A matrix with named columns", "A function for data import", "A data structure that can contain different data types"))
        list.add(QuestionManager("Which function in R can find relations between variables using a scatterplot?",
            "scatter()", "plot()", "relate()", "relation()", "plot()"))
        list.add(QuestionManager("How can you explore categorical variables in R?",
            "Using bar plots", "Using matrices", "Using scatterplots", "Using arrays", "Using bar plots"))

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
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
