package com.example.mymessageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference RV
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // fetchData
        List<Message> messageList = getMessages();

        // connect it all
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(mAdapter);
    }

    private List<Message> getMessages() {
        Message message1 = new Message("1", "Mom", "What's up", "10:30pm");
        Message message2 = new Message("2", "Dad", "Don't be late", "2pm");
        Message message3 = new Message("3", "Vika", "Let's hang", "5pm");
        List<Message> messageList = new ArrayList<>();
        messageList.add(message1);
        messageList.add(message2);
        messageList.add(message3);
        return messageList;
    }
}