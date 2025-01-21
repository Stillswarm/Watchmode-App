package com.example.watchmodeapp.ui.title_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.watchmodeapp.R
import com.example.watchmodeapp.model.Title
import com.example.watchmodeapp.ui.common.AsyncImageLoader
import com.example.watchmodeapp.ui.common.RatingStars

@Composable
fun TitleDetailsContent(
    title: Title,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Box {
            DisplayImage(backdrop = title.backdrop, poster = title.poster)

            Spacer(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.surface,
                            )
                        )
                    )
            )

            Box(
                modifier = Modifier.matchParentSize(),
                contentAlignment = Alignment.BottomStart
            ) {
                TitleWithGenres(
                    title = title.title,
                    genreNames = title.genreNames
                )
            }
        }

        if (title.userRating != null)
            RatingStars(title.userRating)
        else Text(
            text = "No Ratings",
            color = textColor,
            style = MaterialTheme.typography.titleLarge
        )

        if (title.plotOverview != null) {
            Text(
                text = title.plotOverview,
                maxLines = 5,
                color = textColor,
                overflow = TextOverflow.Ellipsis,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 4.dp)

            )
        }

        if (title.runtimeMinutes != null) {
            Text(
                text = "Runtime: ${title.runtimeMinutes} min",
                color = textColor,
                fontSize = 20.sp
            )
        }

        if (title.releaseDate != null) {
            Text(
                text = "Release Date: ${title.releaseDate}",
                color = textColor,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp
            )
        }

        Spacer(Modifier.height(64.dp))

        Spacer(Modifier.weight(1f))

        Text(
            text = "© Created by Abhinav",
            color = textColor,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DisplayImage(backdrop: String?, poster: String?) {
    if (backdrop != null) {
        AsyncImageLoader(
            modifier = Modifier.fillMaxWidth(),
            imageUrl = backdrop,
            contentDescription = "Title Backdrop"
        )
    } else if (poster != null) {
        AsyncImageLoader(
            modifier = Modifier.fillMaxWidth(),
            imageUrl = poster,
            contentDescription = "Title Poster"
        )
    } else {
        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
            painter = painterResource(R.drawable.placeholder_image),
            contentDescription = "No Image"
        )
    }

}

@Composable
fun TitleWithGenres(title: String, genreNames: List<String>?, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.padding(4.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        if (genreNames != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                genreNames.joinToString(",")
            }
        }
        HorizontalDivider(thickness = 2.dp)
    }
}