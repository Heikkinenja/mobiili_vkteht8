package viewmodel.TodoViewModel

package com.example.todolist.viewmodel
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.model.Todo
import com.example.todolist.model.TodosApi
import kotlinx.coroutines.launch
class TodoViewModel :ViewModel(){
    var todos = mutableStateListOf<Todo>()
        private set
    init {
        getTodosList()
    }
    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi!!.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            } catch(e:Exception) {
                Log.d("TODOVIEWMODEL", e.message.toString())
            }
        }
    }
}
