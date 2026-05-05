package com.adamchaniago0025.ebrix.ocr

import android.graphics.BitmapFactory
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

actual class OCRProcessor actual constructor() {
    actual fun recognizeText(imageBytes: ByteArray, onResult: (String) -> Unit) {
        try {
            val bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            val image = InputImage.fromBitmap(bitmap, 0)
            val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

            recognizer.process(image)
                .addOnSuccessListener { visionText ->
                    onResult(visionText.text)
                }
                .addOnFailureListener {
                    onResult("Gagal membaca teks: ${it.message}")
                }
        } catch (e: Exception) {
            onResult("Error: ${e.message}")
        }
    }
}