package com.kamalnathvg.mobirr.feature_radarr.movie_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
internal fun MovieListRoot(
    viewModel: MovieListViewModel = MovieListViewModel(),
    onMovieClick: (Movie) -> Unit
){
    val state = viewModel.state.collectAsStateWithLifecycle()


}



@Composable
fun MovieListScreen(){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.CenterVertically
    ) {

    }
}





