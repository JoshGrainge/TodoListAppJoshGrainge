package com.example.todolistjoshgrainge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText input_field_text;

    ListView todo_list_view;
    ArrayList<TodoItem> items = new ArrayList<>();

    public static int itemsCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign variables and button logic
        input_field_text = findViewById(R.id.input_field);
        todo_list_view = findViewById(R.id.todo_list_view);
        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // Add button functionality
        if(view.getId() == R.id.add_button)
        {
            // Get input field text
            String inputText = input_field_text.getText().toString();

            // Create new TodoItem with input fields text
            TodoItem newItem = new TodoItem(inputText);

            // Add new item to array list, then update listviews adapter with new items collection
            items.add(newItem);
            TodoItemAdapter adapter = new TodoItemAdapter(items, this);

            // This adds on click and text view functionality to newly added listview item
            adapter.getView(itemsCount, null, new LinearLayout(todo_list_view.getContext()));

            // Increment items counter variable
            itemsCount++;

            // Set listview adapter to be new adapter
            todo_list_view.setAdapter(adapter);

            // Clear input field text
            input_field_text.getText().clear();
        }
    }
}
