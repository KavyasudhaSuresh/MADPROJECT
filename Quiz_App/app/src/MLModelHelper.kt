package com.rajkishorbgp.quizapplication

import android.content.res.AssetManager
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class MLModelHelper {
    private lateinit var tflite: Interpreter

    // Load the TensorFlow Lite model from assets
    fun loadModel(assetManager: AssetManager, modelPath: String) {
        val fileDescriptor = assetManager.openFd(modelPath)
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startOffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        val modelBuffer: MappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
        tflite = Interpreter(modelBuffer)
    }

    // Run inference on the input data
    fun runInference(input: FloatArray): FloatArray {
        val output = Array(1) { FloatArray(1) } // Adjust the output shape if necessary
        tflite.run(input, output)
        return output[0]
    }

    // Release resources when no longer needed
    fun close() {
        if (::tflite.isInitialized) {
            tflite.close()
        }
    }
}
