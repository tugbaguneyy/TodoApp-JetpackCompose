package com.example.finalapp.presentation.home

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.finalapp.R
import com.example.finalapp.navigation.Screen
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SuppressLint("SuspiciousIndentation")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavController) {
    val viewModel = hiltViewModel<HomeScreenViewModel>()
    val todoList = viewModel.list.collectAsStateWithLifecycle()

    val currentDate = LocalDate.now()
    val dateFormatted = currentDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))


        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.header_todolist),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = dateFormatted,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.Gray
                    ),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            HorizontalDivider(thickness = 1.dp, color = Color.Black)

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(todoList.value.size) { index ->
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = todoList.value[index].isCompleted,
                            onCheckedChange = { isChecked ->
                                viewModel.updateTodoCompletion(todoList.value[index].id, isChecked)
                            }
                        )
                        Text(
                            modifier = Modifier
                                .clickable { navController.navigate(Screen.Detail(todoList.value[index].id)) },
                            text = todoList.value[index].title
                        )
                    }
                }
                item {
                    TextButton(onClick = { navController.navigate(Screen.Add) }) {
                        Text(
                            text = "+ Add Todo",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Gray
                        )
                    }
                }

            }
        }
    }

