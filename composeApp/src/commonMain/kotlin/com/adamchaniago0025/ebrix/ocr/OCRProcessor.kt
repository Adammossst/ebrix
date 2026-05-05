package com.adamchaniago0025.ebrix.ocr

expect class OCRProcessor() {
    fun recognizeText(imageBytes: ByteArray, onResult: (String) -> Unit)
}