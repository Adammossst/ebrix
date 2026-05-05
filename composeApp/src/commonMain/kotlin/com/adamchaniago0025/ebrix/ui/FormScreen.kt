package com.adamchaniago0025.ebrix.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adamchaniago0025.ebrix.data.ScanData
import com.adamchaniago0025.ebrix.viewmodel.ScanViewModel
import com.adamchaniago0025.ebrix.ocr.OCRProcessor // 1. TAMBAHKAN IMPORT INI
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    viewModel: ScanViewModel,
    onBack: () -> Unit
) {
    var petak by remember { mutableStateOf("") }
    var brix by remember { mutableStateOf("") }

    // 2. TARO INISIALISASI DI SINI (Di atas Scaffold)
    val ocrProcessor = remember { OCRProcessor() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tambah Data Scan") },
                navigationIcon = {
                    Button(onClick = onBack) { Text("<") }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = petak,
                onValueChange = { petak = it },
                label = { Text("Nama Petak") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = brix,
                onValueChange = { brix = it },
                label = { Text("Nilai Brix") },
                modifier = Modifier.fillMaxWidth()
            )

            // 3. CONTOH TOMBOL UNTUK SCAN OCR
            Button(
                onClick = {
                    // Logika Scan OCR
                    // Nantinya imageBytes didapat dari hasil foto kamera
                    val dummyImage = ByteArray(0)

                    ocrProcessor.recognizeText(dummyImage) { hasilTeks ->
                        // Jika hasil OCR adalah angka Brix, masukkan ke state brix
                        brix = hasilTeks
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Scan Teks dari Kamera")
            }

            Button(
                onClick = {
                    val newData = ScanData(
                        id = Random.nextInt(1000, 9999),
                        petak = petak,
                        imageBytes = null,
                        brix = brix,
                        lat = "0.0",
                        lon = "0.0",
                        timestamp = "Sekarang"
                    )
                    viewModel.addData(newData)
                    onBack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Simpan Data")
            }
        }
    }
}