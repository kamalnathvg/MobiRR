package org.kamalnathvg.mobirr.radarr.presentation.movie_list

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger

private const val TAG = "FilterLabelSection"

@Composable
internal fun FilterLabelSection(
    onFilterChanged: (FilterType) -> Unit,
    currentFilterType: FilterType
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        FilterType.entries.filter { it != FilterType.ALL }.forEach { filterType ->
            FilterChip(
                onClick = {
                    val updatedFilter =
                        if (currentFilterType == filterType) FilterType.ALL else filterType
                    Logger.d(TAG) { currentFilterType.name }
                    onFilterChanged(updatedFilter)
                },
                selected = currentFilterType == filterType,
                label = {
                    Text(filterType.label)
                },
                shape = RoundedCornerShape(8.dp),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}

