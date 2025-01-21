package com.example.watchmodeapp.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.watchmodeapp.AppViewModel
import com.example.watchmodeapp.model.Title
import com.example.watchmodeapp.ui.common.ButtonWithIcon

@Composable
fun HomeScreenContent(
    titles: List<Title>,
    onTitleDetailsRequest: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppViewModel
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Row {
                    FilterChip(
                        selected = viewModel.moviesSelected,
                        onClick = viewModel::setMovies,
                        label = { Text("Movies") },
                        border = if (viewModel.moviesSelected) BorderStroke(
                            1.dp,
                            MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        else BorderStroke(0.dp, Color.Transparent)
                    )

                    FilterChip(
                        selected = viewModel.tvSelected,
                        onClick = viewModel::setTv,
                        label = { Text("TV Shows") },
                        border = if (viewModel.tvSelected) BorderStroke(
                            1.dp,
                            MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        else BorderStroke(0.dp, Color.Transparent)
                    )
                }
            }

            LazyVerticalGrid(
                modifier = Modifier.weight(1f),
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(titles) {
                    TitleItem(it, onTitleDetailsRequest)
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (viewModel.pageNo > 1) {
                    ButtonWithIcon(
                        imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                        contentDescription = "Previous Page",
                        label = "Prev",
                        onClick = { viewModel.previousPage() }
                    )
                }

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    ButtonWithIcon(
                        imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                        contentDescription = "Next Page",
                        label = "Next",
                        onClick = { viewModel.nextPage() },
                    )
                }
            }
        }
    }
}