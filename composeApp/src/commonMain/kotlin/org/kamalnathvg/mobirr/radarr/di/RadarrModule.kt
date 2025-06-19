package org.kamalnathvg.mobirr.radarr.di

import org.kamalnathvg.mobirr.radarr.data.DummyRadarrRepository
import org.kamalnathvg.mobirr.radarr.data.RadarrRepository
import org.kamalnathvg.mobirr.radarr.data.RadarrRepositoryImpl
import org.kamalnathvg.mobirr.radarr.domain.AddMovieUseCase
import org.kamalnathvg.mobirr.radarr.domain.AddReleaseUseCase
import org.kamalnathvg.mobirr.radarr.domain.DeleteMovieFileUseCase
import org.kamalnathvg.mobirr.radarr.domain.GetMovieDetailsByIdUseCase
import org.kamalnathvg.mobirr.radarr.domain.GetMoviesUseCase
import org.kamalnathvg.mobirr.radarr.domain.GetReleasesUseCase
import org.kamalnathvg.mobirr.radarr.domain.LookUpMovieUseCase
import org.kamalnathvg.mobirr.radarr.presentation.movie_add.MovieAddViewModel
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsViewModel
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val radarrModule = module{
    viewModelOf(::MovieListViewModel)
    viewModelOf(::MovieDetailsViewModel)
    viewModelOf(::MovieAddViewModel)
    single<RadarrRepository>{ DummyRadarrRepository() }
//    single<RadarrRepository>{ RadarrRepositoryImpl(get()) }
    factory{ GetMoviesUseCase(get()) }
    factory { GetMovieDetailsByIdUseCase(get()) }
    factory { GetReleasesUseCase(get()) }
    factory { DeleteMovieFileUseCase(get()) }
    factory { AddReleaseUseCase(get()) }
    factory { AddMovieUseCase(get()) }
    factory { LookUpMovieUseCase(get()) }
}