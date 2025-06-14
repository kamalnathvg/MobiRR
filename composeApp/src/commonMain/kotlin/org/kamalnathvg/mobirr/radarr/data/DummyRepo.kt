package org.kamalnathvg.mobirr.radarr.data

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import coil3.util.DebugLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import mobirr.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie

internal sealed interface DummyRepo{
    data class DynamicString(val value: String): DummyRepo
    class RawResourceId(
        val id: StringResource,
        val args: Array<Any> = arrayOf()
    ): DummyRepo

    suspend fun asMovies(): List<MovieDto>{
        var moviesDto: List<MovieDto> = emptyList()
        withContext(Dispatchers.IO) {
            val bytes = Res.readBytes(DUMMY_MOVIE_FILE)
            val json = Json{ignoreUnknownKeys = true}
            moviesDto = json.decodeFromString<List<MovieDto>>(bytes.decodeToString())
            println("MOVIES DTO: ${moviesDto.firstOrNull()}")
        }
        return moviesDto
    }
    companion object{
        const val DUMMY_MOVIE_FILE = "files/dummyMovies.json"
    }
}


