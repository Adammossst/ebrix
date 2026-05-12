package com.adamchaniago0025.ebrix.ocr

actual class OCRProcessor actual constructor() {
    actual fun recognizeText(imageBytes: ByteArray, onResult: (String) -> Unit) {
        // Implementasi placeholder untuk Desktop
        onResult("OCR belum diimplementasikan untuk versi Desktop")
    }
}