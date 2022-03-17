package com.example.todolistjoshgrainge;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TodoItemAdapter  extends ArrayAdapter<TodoItem>{

    ArrayList<TodoItem> todoItems;

    public TodoItemAdapter(ArrayList<TodoItem> items, Context context)
    {
        super(context, R.layout.todo_item, R.id.todo_text, items);
        this.todoItems = items;
    }

    // Dynamically sets textview text and button onclick when adding a TodoItem to array list
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        // Create new todo_item view
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.todo_item, null);
        }

        // Get TodoItem from array list at index position
        TodoItem item = todoItems.get(position);
        if (item != null) {
            // Set text and onclick
            TextView text = (TextView) v.findViewById(R.id.todo_text);
            text.setText(todoItems.get(position).getTodoText());
            Button btn = (Button) v.findViewById(R.id.todo_remove_button);
            //set as the tag the position parameter
            btn.setTag(new Integer(position));
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Remove item button logic for when task is completed
                    MainActivity.itemsCount--;
                    todoItems.remove(position);
                    notifyDataSetChanged();
                }
            });
        }

        // Return v because of getView needing to return view
        return v;
    }

}
