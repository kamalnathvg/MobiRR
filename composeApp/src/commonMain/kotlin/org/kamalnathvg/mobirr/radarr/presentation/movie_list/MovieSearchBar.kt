import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
internal fun MovieSearchBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onImeSearch: () -> Unit,
    onFocusChanged: () -> Unit
) {
    OutlinedTextField(
        value = searchQuery,
        shape = RoundedCornerShape(100.dp),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent
        ),
        onValueChange = {
            onSearchQueryChange(it)
        },
        leadingIcon = {
            IconButton(onClick = onFocusChanged
            ) {
                Icon(
                    Icons.Default.Menu, contentDescription = null
                )
            }
        },
        trailingIcon = {
            IconButton(
                onClick = onImeSearch,
            ) {
                Icon(
                    Icons.Default.Search, contentDescription = null
                )
            }
        },
        keyboardActions = KeyboardActions(onSearch = {
            onImeSearch()
        }),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .minimumInteractiveComponentSize()
            .onFocusChanged { focusState ->
                if (!focusState.isFocused){
                    onFocusChanged()
                }
            }

    )
}