package com.adamchaniago0025.ebrix.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adamchaniago0025.ebrix.viewmodel.ScanViewModel
import com.adamchaniago0025.ebrix.data.ScanData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: ScanViewModel,
    onAddClick: () -> Unit,
    onItemClick: (Int) -> Unit
) {
    val dataList by viewModel.dataList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("E-Brix Home") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Text("+")
            }
        }
    ) { paddingValues ->
        if (dataList.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize().padding(paddingValues), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("Belum ada data scan.")
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(dataList) { data ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .clickable { onItemClick(data.id) }
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = "Petak: ${data.petak}", style = MaterialTheme.typography.titleMedium)
                            Text(text = "Brix: ${data.brix}", style = MaterialTheme.typography.bodyMedium)
                            Text(text = "Waktu: ${data.timestamp}", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}