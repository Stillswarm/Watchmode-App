
# Watchmode App

## Features
- Data is fetched from the Watchmode API.
- Fluently switch between the "Movies" and "TV Series" sections.
- View the details of each item on a simple UI.
- Paginated Content.
- Easily switch to the next/previous page.
- Shimmer Effect during data loading.
- LazyGrid for efficient rendering.
- All errors handled and communicated gracefully.
- Android Best Practices including MVVM architecture, Dependency Injection, Material Theming

## Technologies Used
- Kotlin 2.1.0
- Jetpack Compose 2024.04.01 - UI Framework
- Koin 3.5.0 - Dependency Injection
- Jetpack Navigation 2.8.5 - Type-safe Navigation
- Jetpack DataStore 1.1.2 - Preferences DataStore
- Retrofit 2.11.0(with kotlinx.serialization converter) - Network Calls
- Coil 3.0.4 - Asynchronous Image Loading

## Project Structure

```
├──    src
|        ├── models
|        |       ├── Title
|        |       ├── TitleList
|        |       └── TitleSummary
|        ├── di
|        |    └── AppModule.kt
|        ├── navigation
|        |            ├── AppNavGraph.kt
|        |            └── Routes.kt
|        ├──    ui
|        |        ├── common   
|        |        |       ├── AppScaffold.kt
|        |        |       ├── AsyncImageLoader.kt
|        |        |       ├── ButtonWithIcon.kt
|        |        |       ├── ErrorScreen.kt
|        |        |       ├── IdleScreen.kt
|        |        |       ├── LoadingScreen.kt
|        |        |       ├── RatingStars.kt
|        |        |       └── ShimmerEffectWrapper.kt
|        |        ├── home   
|        |        |        ├── HomeDummy.kt
|        |        |        ├── TitleItem.kt
|        |        |        ├── HomeScreenContent.kt
|        |        |        └── HomeScreen.kt
|        |        ├── title_details
|        |        |             ├── TitleDetailsScreen.kt
|        |        |             └── TitleDetailsViewModel.kt
|        |        └── theme
|        |                 ├── Color.kt
|        |                 ├── Theme.kt
|        |                 └── Type.kt
|        ├── util
|        |      ├── RequestStatus.kt 
|        |      └── SortingOrder.kt
|        ├── AppViewModel.kt
|        ├── WatchmodeApp.kt
|        ├── WatchmodeApplication.kt
|        └── MainActivity
```
