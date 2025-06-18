package org.kamalnathvg.mobirr.radarr.di

import org.kamalnathvg.mobirr.radarr.data.RadarrRepository
import org.kamalnathvg.mobirr.radarr.data.RadarrRepositoryImpl
import org.kamalnathvg.mobirr.radarr.domain.GetMoviesUseCase
import org.kamalnathvg.mobirr.radarr.presentation.movie_details.MovieDetailsViewModel
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val radarrModule = module{
    viewModelOf(::MovieListViewModel)
    viewModelOf(::MovieDetailsViewModel)
    single<RadarrRepository>{ RadarrRepositoryImpl(get()) }
    factory{ GetMoviesUseCase(get()) }
}