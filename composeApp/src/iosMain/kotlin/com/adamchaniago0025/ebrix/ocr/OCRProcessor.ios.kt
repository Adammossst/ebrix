package com.adamchaniago0025.ebrix.ocr

actual class OCRProcessor actual constructor() {
    actual fun recognizeText(imageBytes: ByteArray, onResult: (String) -> Unit) {
        // Placeholder untuk iOS
        onResult("OCR iOS belum aktif (Membutuhkan Apple Vision)")
    }
}