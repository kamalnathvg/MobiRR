package org.kamalnathvg.mobirr.settings.presentation.settings

internal sealed interface SettingAction {
    data class OnRadarrUrlChange(val url: String): SettingAction
    data object TestCurrentUrl: SettingAction
    data object SaveConfiguration: SettingAction
}