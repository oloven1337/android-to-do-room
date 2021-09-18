package com.example.todolistroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.todolistroom.Model.Note;
import com.example.todolistroom.Presentation.View.Adapters.NoteListAdapter;
import com.example.todolistroom.Presentation.View.NoteActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NoteListAdapter.OnNoteListener {

    private static final String TAG = "NoteListActivity";

    private RecyclerView mRecyclerView;
    private ArrayList<Note> mNotes = new ArrayList<>();
    private NoteListAdapter mNoteListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);

        Note note = new Note("New Note", "content note", "Jan 2019");
        Log.d(TAG, "onCreate: " + note.toString());
        initRecyclerView();
        insertFakeData();
    }

    private void insertFakeData() {
        for (int i = 0; i < 15; i++) {
            Note note = new Note();
            note.setTitle("title $ " + i);
            note.setContent("content $" + i);
            note.setTimestamp("Sep 2021 ");
            mNotes.add(note);
        }
        mNoteListAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mNoteListAdapter = new NoteListAdapter(mNotes, this);
        mRecyclerView.setAdapter(mNoteListAdapter);
    }

    @Override
    public void onNoteClick(int position) {
        Log.d(TAG, "onNoteClick: clicked" + position);

        Intent intent = new Intent(this, NoteActivity.class);
        intent.putExtra("selected_note", mNotes.get(position));
        startActivity(intent);
    }
}