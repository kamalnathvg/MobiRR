package org.kamalnathvg.mobirr.settings.presentation.settings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal data class SettingScreenState(
    val currentRadarrUrl: String = "",
    val errorMessage: String? = null
)

internal class SettingViewModel: ViewModel() {
    private val _state = MutableStateFlow(SettingScreenState())
    val state = _state.asStateFlow()


    fun onAction(action: SettingAction){
        when(action){
            is SettingAction.OnRadarrUrlChange -> {
                _state.update {
                    it.copy(
                        currentRadarrUrl = action.url
                    )
                }
            }
            SettingAction.SaveConfiguration -> {

            }
            SettingAction.TestCurrentUrl -> {

            }
        }
    }
}