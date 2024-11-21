package com.rajkishorbgp.quizapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.rajkishorbgp.quizapplication.databinding.ActivityDeepQuizBinding

class DeepLearningQuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeepQuizBinding
    private lateinit var list: ArrayList<QuestionManager>
    private var count = 0
    private var score = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeepQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        list = ArrayList()

        // Adding 25 Deep Learning Questions
        list.add(QuestionManager("What is the main role of a perceptron in a neural network?",
            "Data visualization", "Feature extraction", "Binary classification", "Error calculation", "Binary classification"))
        list.add(QuestionManager("Which activation function is commonly used for binary classification?",
            "ReLU", "Sigmoid", "Tanh", "Softmax", "Sigmoid"))
        list.add(QuestionManager("In a multi-layer neural network, which layer is responsible for the final output?",
            "Hidden layer", "Input layer", "Output layer", "Middle layer", "Output layer"))
        list.add(QuestionManager("The softmax function is primarily used for which type of classification?",
            "Binary classification", "Regression", "Multi-class classification", "Clustering", "Multi-class classification"))
        list.add(QuestionManager("What is the main advantage of using the ReLU activation function?",
            "Avoids vanishing gradient", "Better for binary classification", "Requires less computation", "Used for output layers", "Avoids vanishing gradient"))
        list.add(QuestionManager("Which loss function is commonly used for regression tasks?",
            "Cross-entropy", "Mean Squared Error", "Hinge Loss", "Binary Cross-entropy", "Mean Squared Error"))
        list.add(QuestionManager("In the context of neural networks, what does 'training' refer to?",
            "Adjusting weights", "Designing network architecture", "Choosing an activation function", "Evaluating performance", "Adjusting weights"))
        list.add(QuestionManager("Which method helps to prevent overfitting in neural networks?",
            "Increasing learning rate", "Using dropout", "Decreasing dataset size", "Reducing epochs", "Using dropout"))
        list.add(QuestionManager("The identity function in neural networks is commonly used in which layer?",
            "Input layer", "Hidden layer", "Output layer", "None", "Output layer"))
        list.add(QuestionManager("What does the term 'epoch' represent in machine learning?",
            "A batch of data", "One pass over the entire dataset", "A set of parameters", "None of the above", "One pass over the entire dataset"))
        list.add(QuestionManager("What is the primary goal of backpropagation in neural networks?",
            "Maximizing accuracy", "Minimizing loss", "Increasing gradient", "Reducing training time", "Minimizing loss"))
        list.add(QuestionManager("Which gradient descent method uses a mini-batch of data?",
            "Stochastic Gradient Descent", "Batch Gradient Descent", "Mini-batch Gradient Descent", "Adam", "Mini-batch Gradient Descent"))
        list.add(QuestionManager("The sigmoid activation function outputs values in which range?",
            "0 to 1", "-1 to 1", "-∞ to +∞", "0 to ∞", "0 to 1"))
        list.add(QuestionManager("In a neural network, what is an epoch?",
            "One iteration through the network", "A pass through the full dataset", "One update to weights", "Training the network", "A pass through the full dataset"))
        list.add(QuestionManager("Which type of neural network is used for sequence data?",
            "CNN", "RNN", "DNN", "GAN", "RNN"))
        list.add(QuestionManager("Which function is used to calculate the error between predicted and actual values?",
            "Loss function", "Activation function", "Output function", "Input function", "Loss function"))
        list.add(QuestionManager("Which layer in a neural network is responsible for initial data input?",
            "Hidden layer", "Output layer", "Input layer", "Pooling layer", "Input layer"))
        list.add(QuestionManager("A perceptron can solve which type of problems?",
            "Non-linear problems", "Linear problems", "Complex problems", "Multi-class problems", "Linear problems"))
        list.add(QuestionManager("Which activation function is most suitable for output layers in multi-class classification?",
            "Sigmoid", "Tanh", "Softmax", "ReLU", "Softmax"))
        list.add(QuestionManager("Which concept refers to updating weights to minimize error?",
            "Forward propagation", "Backpropagation", "Convolution", "Pooling", "Backpropagation"))
        list.add(QuestionManager("Which part of the neural network learns features through training?",
            "Weights", "Bias", "Activation function", "Learning rate", "Weights"))
        list.add(QuestionManager("Which technique adjusts the learning rate during training?",
            "Dropout", "Learning rate decay", "Batch normalization", "Backpropagation", "Learning rate decay"))
        list.add(QuestionManager("Which neural network is best suited for image classification?",
            "RNN", "CNN", "DNN", "GAN", "CNN"))
        list.add(QuestionManager("Which term describes a layer that reduces dimensionality in CNNs?",
            "Pooling", "Dropout", "Convolution", "Dense", "Pooling"))
        list.add(QuestionManager("Which optimizer uses adaptive learning rates?",
            "SGD", "Adam", "RMSProp", "Adagrad", "Adam"))

        binding.totalQuestion.text = "${list.size}"

        if (list.isNotEmpty()) {
            setQuestion()
        }

        binding.optionA.setOnClickListener { handleAnswer(binding.optionA.text.toString()) }
        binding.optionB.setOnClickListener { handleAnswer(binding.optionB.text.toString()) }
        binding.optionC.setOnClickListener { handleAnswer(binding.optionC.text.toString()) }
        binding.optionD.setOnClickListener { handleAnswer(binding.optionD.text.toString()) }

        binding.next.setOnClickListener {
            count++
            if (count >= list.size) {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("COUNT", count)
                startActivity(intent)
                finish()
            } else {
                setQuestion()
            }
        }
    }

    private fun setQuestion() {
        binding.questionCount.text = "${count + 1}."
        val question = list[count]
        binding.question.text = question.question
        binding.optionA.text = question.optionA
        binding.optionB.text = question.optionB
        binding.optionC.text = question.optionC
        binding.optionD.text = question.optionD
        binding.optionsRadioGroup.clearCheck()
    }

    private fun handleAnswer(selectedAnswer: String) {
        if (list[count].answer == selectedAnswer) {
            score++
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
