package com.burhanuday.renaissance_todolist;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements RecyclerAdapter.OnItemClickListener {
    ArrayList<String> todoItems = new ArrayList<>();
    RecyclerView todolist;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText editText = findViewById(R.id.et_new);
        Button add = findViewById(R.id.bt_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTodo = editText.getText().toString().trim();
                if (newTodo.equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "Enter text", Toast.LENGTH_SHORT).show();
                    return;
                }
                todoItems.add(newTodo);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

        todolist = findViewById(R.id.id_list);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        todolist.setLayoutManager(mLayoutManager);

        adapter = new RecyclerAdapter(todoItems, this);
        todolist.setAdapter(adapter);
    }

    @Override
    public void onItemClick(String item) {
        todoItems.remove(item);
        adapter.notifyDataSetChanged();
    }
}
