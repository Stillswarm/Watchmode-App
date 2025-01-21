package com.example.watchmodeapp.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.watchmodeapp.AppViewModel
import com.example.watchmodeapp.ui.common.ErrorScreen
import com.example.watchmodeapp.ui.common.IdleScreen
import com.example.watchmodeapp.ui.common.ShimmerEffect
import com.example.watchmodeapp.util.RequestStatus
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    onTitleDetailsRequest: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getAllPosts(1, viewModel.getTypesList(), initial = true)
    }
    val requestStatus = viewModel.requestStatus

    when (requestStatus) {
        is RequestStatus.Error -> {
            ErrorScreen(
                modifier = modifier,
                errorMsg = requestStatus.msg
            )
        }

        RequestStatus.Idle -> {
            IdleScreen(modifier)
        }

        RequestStatus.Loading -> {
            ShimmerEffect(modifier) { brush, mod ->
                HomeDummy(brush, mod)
            }
        }

        is RequestStatus.Success -> {
            HomeScreenContent(
                titles = requestStatus.data,
                modifier = modifier,
                onTitleDetailsRequest = onTitleDetailsRequest,
                viewModel = viewModel
            )
        }
    }
}