package com.adamchaniago0025.ebrix.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adamchaniago0025.ebrix.viewmodel.ScanViewModel
import com.adamchaniago0025.ebrix.data.ScanData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    viewModel: ScanViewModel,
    id: Int,
    onBack: () -> Unit
) {
    val data = viewModel.getDataById(id)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Scan") },
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
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (data != null) {
                Text("ID: ${data.id}", style = MaterialTheme.typography.titleLarge)
                Text("Petak: ${data.petak}", style = MaterialTheme.typography.bodyLarge)
                Text("Brix: ${data.brix}", style = MaterialTheme.typography.bodyLarge)
                Text("Latitude: ${data.lat}")
                Text("Longitude: ${data.lon}")
                Text("Waktu: ${data.timestamp}")
            } else {
                Text("Data tidak ditemukan.")
            }
        }
    }
}