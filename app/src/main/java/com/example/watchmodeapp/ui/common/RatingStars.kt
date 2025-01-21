package com.example.watchmodeapp.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RatingStars(rating: Double, modifier: Modifier = Modifier) {
    val ratingInt = rating.toInt()
    val stars = (ratingInt + 1) / 2

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(modifier = modifier.fillMaxWidth()) {
            for (i in 1..stars) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "filled star",
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.size(36.dp)
                )
            }

            for (i in 1..(5 - stars)) {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "unfilled star",
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.size(36.dp)
                )
            }
        }
    }
}