package com.example.todolistjoshgrainge;

// TodoItem to contain each items string

public class TodoItem {

    String todoText;

    public TodoItem(String todoText)
    {
        this.todoText = todoText;
    }

    public String getTodoText() { return todoText; }

}