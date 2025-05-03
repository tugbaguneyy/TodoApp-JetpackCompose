package com.example.finalapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.finalapp.R

@Composable
fun DateHeader(
    dateFormatted: String,
    isSearching: Boolean,
    searchText: String,
    onSearchClick: () -> Unit,
    onSearchTextChange: (String) -> Unit
) {

        if (isSearching) {
            MySearchBar(
                searchText = searchText,
                onSearchTextChange = onSearchTextChange,
                onCloseClick = onSearchClick
            )
        }
        else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.header_todolist),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = dateFormatted,
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            HorizontalDivider(thickness = 1.dp, color = Color.Black)
        }
    }


