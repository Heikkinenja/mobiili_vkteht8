package com.example.todoo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel // Correct import
import com.example.todoo2.ui.theme.Todoo2Theme
import com.example.todoo2.viewmodel.TodoViewModel
import com.example.todoo2.model.Todo
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Todoo2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TodoScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun TodoScreen(modifier: Modifier = Modifier, todoViewModel: TodoViewModel = viewModel()) {
    // Get the todos from the ViewModel and pass them to TodoList
    TodoList(todos = todoViewModel.todos)
}
@Composable
fun TodoList(todos: List<Todo>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(todos) { todo ->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        }
    }
}