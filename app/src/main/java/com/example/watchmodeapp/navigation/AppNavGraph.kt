package com.example.watchmodeapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.watchmodeapp.AppViewModel
import com.example.watchmodeapp.ui.common.AppScaffold
import com.example.watchmodeapp.ui.home.HomeScreen
import com.example.watchmodeapp.ui.title_details.TitleDetailsScreen

fun NavGraphBuilder.appNavGraph(navController: NavHostController, appViewModel: AppViewModel) {

    composable<Home> {
        AppScaffold(
            title = "Watchmode",
            canNavigateBack = false,
        ) {
            HomeScreen(
                modifier = it,
                onTitleDetailsRequest = { navController.navigate(Details(it)) },
                viewModel = appViewModel
            )
        }
    }

    composable<Details> { backStackEntry ->
        val id = backStackEntry.toRoute<Details>().id

        AppScaffold(
            title = "Details",
            canNavigateBack = true,
            onNavigateBack = { navController.popBackStack() }
        ) {
            TitleDetailsScreen(
                modifier = it,
                id = id,
                viewModel = appViewModel
            )
        }
    }
}