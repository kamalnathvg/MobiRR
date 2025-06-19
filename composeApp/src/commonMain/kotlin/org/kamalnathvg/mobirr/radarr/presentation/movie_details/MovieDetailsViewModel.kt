package org.kamalnathvg.mobirr.radarr.presentation.movie_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.kamalnathvg.mobirr.radarr.data.ReleaseDto
import org.kamalnathvg.mobirr.radarr.domain.AddReleaseUseCase
import org.kamalnathvg.mobirr.radarr.domain.DeleteMovieFileUseCase
import org.kamalnathvg.mobirr.radarr.domain.GetMovieDetailsByIdUseCase
import org.kamalnathvg.mobirr.radarr.domain.GetReleasesUseCase
import org.koin.core.component.KoinComponent

private const val TAG = "MovieDetailsViewModel"

internal data class MovieDetailsScreenState(
    val movieDetailsForView: MovieDetailsForView? = null,
    val screenErrorMessage: String? = null,
    val releases: List<ReleaseDetailsForView>? = null,
    val releasesErrorMessage: String? = null
)

internal class MovieDetailsViewModel(
    private val getMovieByIdUseCase: GetMovieDetailsByIdUseCase,
    private val getReleasesUseCase: GetReleasesUseCase,
    private val deleteMovieFileUseCase: DeleteMovieFileUseCase,
    private val addReleaseUseCase: AddReleaseUseCase,
) : ViewModel(), KoinComponent {

    private val _state = MutableStateFlow(MovieDetailsScreenState())
    val state = _state.asStateFlow()

    private var cachedReleases = listOf<ReleaseDto>()

    fun onAction(action: MovieDetailsAction) {
        Logger.d(TAG) { action::class.qualifiedName.toString() }
        when (action) {
            is MovieDetailsAction.GetMovieDetails -> {
                viewModelScope.launch {
                    val result = getMovieByIdUseCase(action.movieId)
                    result
                        .onFailure { error ->
                            _state.update {
                                it.copy(
                                    screenErrorMessage = error.message
                                )
                            }
                        }
                        .onSuccess { movie ->
                            _state.update {
                                it.copy(
                                    movieDetailsForView = movie
                                )
                            }
                        }
                }
            }

            is MovieDetailsAction.DeleteMovieFile -> {
                viewModelScope.launch {
                    val result: Result<Unit> = deleteMovieFileUseCase(action.fileId)
                    result
                        .onFailure { e ->
                            _state.update {
                                it.copy(
                                    screenErrorMessage = e.message
                                )
                            }
                        }
                }
            }

            is MovieDetailsAction.GetReleases -> {
                viewModelScope.launch {
                    val result: Result<List<ReleaseDto>> = getReleasesUseCase(action.movieId)
                    result
                        .onFailure { e ->
                            _state.update {
                                it.copy(
                                    releasesErrorMessage = e.message
                                )
                            }
                        }
                        .onSuccess { releases ->
                            cachedReleases = releases
                            _state.update {
                                it.copy(
                                    releases = releases.map { it.toReleaseDetailsForView() }
                                )
                            }
                        }
                }
            }

            is MovieDetailsAction.AddRelease -> {
                    viewModelScope.launch {
                        val result: Result<Unit> = addReleaseUseCase(cachedReleases.first { it.guid == action.guid })
                        result
                            .onSuccess {

                            }
                            .onFailure {

                            }
                    }
            }
        }
    }
}