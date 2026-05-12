package com.adamchaniago0025.ebrix

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adamchaniago0025.ebrix.ui.DetailScreen
import com.adamchaniago0025.ebrix.ui.FormScreen
import com.adamchaniago0025.ebrix.ui.HomeScreen
import com.adamchaniago0025.ebrix.viewmodel.ScanViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        // Tambahkan Surface agar ada latar belakang fisik dan mengisi seluruh layar
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AppNavInternal()
        }
    }
}

@Composable
fun AppNavInternal() {
    val navController = rememberNavController()
    val viewModel: ScanViewModel = viewModel { ScanViewModel() }

    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                viewModel = viewModel,
                onAddClick = { navController.navigate("form") },
                onItemClick = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }

        composable("form") {
            FormScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }

        composable("detail/{id}") { backStack ->
            val id = backStack.arguments?.getString("id")?.toInt() ?: 0

            DetailScreen(
                viewModel = viewModel,
                id = id,
                onBack = { navController.popBackStack() }
            )
        }
    }
}