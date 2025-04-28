package com.example.finalapp.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.finalapp.data.local.TodoEntitiy

@Composable
fun TodoItem(
    todo: TodoEntitiy,
    onCheckedChange: (Boolean) -> Unit,
    onClick: () -> Unit
) {
    val alpha = if (todo.isCompleted) 0.5f else 1f  // solukluk
    val textDecoration = if (todo.isCompleted) TextDecoration.LineThrough else TextDecoration.None  // üstü çizili mi

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() }
            .alpha(alpha),  // satır komple soluk olsun
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = todo.isCompleted,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = todo.title,
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.bodyLarge.copy(
                textDecoration = textDecoration,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = alpha)
            )
        )
    }
}
