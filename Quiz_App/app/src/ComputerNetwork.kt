package com.rajkishorbgp.quizapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.rajkishorbgp.quizapplication.databinding.ActivityComputerNetworkBinding

class ComputerNetworkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComputerNetworkBinding
    private lateinit var list: ArrayList<QuestionManager>
    private var count = 0
    private var score = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComputerNetworkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = "Computer Network"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        list = ArrayList()

        // Add Computer Network Questions
        list.add(QuestionManager("What is the primary purpose of a network?", "A) To share resources and information", "B) To store data", "C) To execute programs", "D) To print documents", "A"))
        list.add(QuestionManager("What is layering in networking?", "A) Grouping similar types of devices", "B) Structuring network functions in hierarchical levels", "C) Combining all protocols into one layer", "D) Removing redundancy from the network", "B"))
        list.add(QuestionManager("Which layer is responsible for logical addressing in the OSI model?", "A) Physical Layer", "B) Data Link Layer", "C) Network Layer", "D) Transport Layer", "C"))
        list.add(QuestionManager("What is the main function of protocols in networking?", "A) To store data", "B) To standardize communication between devices", "C) To delete data", "D) To enhance encryption", "B"))
        list.add(QuestionManager("Which architecture forms the basis of the Internet?", "A) Client-Server", "B) Peer-to-Peer", "C) Distributed", "D) Centralized", "A"))
        list.add(QuestionManager("What is a socket in networking?", "A) A physical connection port", "B) An endpoint for communication between applications", "C) A security protocol", "D) A network topology", "B"))
        list.add(QuestionManager("What is the primary role of the link layer?", "A) To control physical data transmission", "B) To manage end-to-end communication", "C) To encrypt data", "D) To allocate IP addresses", "A"))
        list.add(QuestionManager("Which technique is used for error detection in the link layer?", "A) CRC (Cyclic Redundancy Check)", "B) Fragmentation", "C) Routing", "D) Masking", "A"))
        list.add(QuestionManager("What is framing in data communication?", "A) Dividing data into blocks for transmission", "B) Encrypting data", "C) Compressing files", "D) Combining packets", "A"))
        list.add(QuestionManager("What does API stand for in networking?", "A) Application Programming Interface", "B) Application Protocol Interface", "C) Automatic Programming Integration", "D) Array Protocol Interface", "A"))
        list.add(QuestionManager("Which type of error correction uses redundant data bits?", "A) Parity Bits", "B) CRC", "C) Hamming Code", "D) Stop-and-Wait", "C"))
        list.add(QuestionManager("What is the main purpose of the TCP protocol?", "A) Error checking", "B) Data formatting", "C) Reliable data transmission", "D) Encryption", "C"))
        list.add(QuestionManager("Which of the following is a protocol used for error detection?", "A) HTTP", "B) TCP", "C) CRC", "D) UDP", "C"))
        list.add(QuestionManager("What is meant by reliable transmission?", "A) Ensuring data is received without errors and in order", "B) Transmitting data at high speed", "C) Encrypting data before transmission", "D) Compressing data packets", "A"))
        list.add(QuestionManager("What does the 'latency' in network performance measure?", "A) Speed of data transfer", "B) Delay in data transmission", "C) Packet loss rate", "D) Data compression ratio", "B"))
        list.add(QuestionManager("Which of the following is not a function of the link layer?", "A) Error detection", "B) Addressing", "C) Routing", "D) Framing", "C"))
        list.add(QuestionManager("What does the term 'bandwidth' refer to in networking?", "A) Amount of data transmitted in a given time", "B) Data compression rate", "C) Speed of light in fiber optics", "D) Distance covered by the signal", "A"))
        list.add(QuestionManager("What type of error detection adds parity bits to data?", "A) Checksum", "B) CRC", "C) Hamming", "D) Parity check", "D"))
        list.add(QuestionManager("What does 'throughput' measure in network performance?", "A) Delay in data transmission", "B) Total data transmitted over a period", "C) Packet size", "D) Frequency of transmission", "B"))
        list.add(QuestionManager("Which protocol provides a connectionless service?", "A) TCP", "B) FTP", "C) UDP", "D) SMTP", "C"))
        list.add(QuestionManager("What is the role of an acknowledgment in TCP?", "A) To ensure packet delivery by notifying successful receipt", "B) To delete unwanted packets", "C) To encrypt the data", "D) To control congestion", "A"))
        list.add(QuestionManager("What is encapsulation in networking?", "A) Wrapping data with protocol information at each layer", "B) Compressing the data", "C) Sending data without headers", "D) Encrypting the data", "A"))
        list.add(QuestionManager("What does 'flow control' in TCP ensure?", "A) Sender does not overwhelm the receiver with data", "B) Data is encrypted", "C) Data is split into frames", "D) Only small packets are transmitted", "A"))
        list.add(QuestionManager("Which type of addressing is used at the link layer?", "A) MAC Address", "B) IP Address", "C) Domain Name", "D) Port Number", "A"))
        list.add(QuestionManager("Which component is essential for implementing reliable data transfer in the link layer?", "A) Parity bits", "B) Acknowledgments", "C) Multicast groups", "D) Encryption keys", "B"))

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

        binding.optionA.setOnClickListener {
            binding.optionA.text.toString().let { answer ->
                countScore(answer)
            }
        }

        binding.optionB.setOnClickListener {
            binding.optionB.text.toString().let { answer ->
                countScore(answer)
            }
        }

        binding.optionC.setOnClickListener {
            binding.optionC.text.toString().let { answer ->
                countScore(answer)
            }
        }

        binding.optionD.setOnClickListener {
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
