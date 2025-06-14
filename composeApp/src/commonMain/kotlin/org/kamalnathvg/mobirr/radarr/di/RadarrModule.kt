package org.kamalnathvg.mobirr.radarr.di

import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val radarrModule = module{
    viewModelOf(::MovieListViewModel)
}