package com.example.watchmodeapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.watchmodeapp.navigation.Home
import com.example.watchmodeapp.navigation.appNavGraph
import org.koin.androidx.compose.koinViewModel

@Composable
fun WatchmodeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val appViewModel: AppViewModel = koinViewModel()

    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = modifier
    ) {

        appNavGraph(navController, appViewModel)
    }
}