package com.example.finalapp.presentation.home.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.finalapp.R

@Composable
fun BottomBar(
    progress: Float,
    isSearching: Boolean,
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onAddClick: () -> Unit,
    onSearchClick: () -> Unit,
    onClearClick: () -> Unit
) {
    Surface(
        tonalElevation = 8.dp,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            if (isSearching) {
                TextField(
                    value = searchText,
                    onValueChange = onSearchTextChange,
                    placeholder = { Text("Search...") },
                    modifier = Modifier.weight(1f),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            } else {
                IconButton(
                    onClick = onAddClick,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Todo",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(onClick = onClearClick,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ink_eraser_24px),
                        contentDescription = "Clear All",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                CircularProgress(progress = progress)
            }

            IconButton(
                onClick = onSearchClick,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = if (isSearching) Icons.Default.Close else Icons.Default.Search,
                    contentDescription = "Search",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
