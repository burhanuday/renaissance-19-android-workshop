package com.burhanuday.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText userInput;
    Button add;
    String text;
    RecyclerView list;
    ListHelper adapter;

    ArrayList<String> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.userInput);
        add = findViewById(R.id.add);
        list = findViewById(R.id.list);

        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this);

        list.setLayoutManager(layoutManager);

        adapter = new ListHelper(itemList);

        list.setAdapter(adapter);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = userInput.getText().toString();

                itemList.add(text);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
