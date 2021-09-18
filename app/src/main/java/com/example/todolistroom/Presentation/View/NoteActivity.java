package com.example.todolistroom.Presentation.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.todolistroom.Model.Note;
import com.example.todolistroom.R;

public class NoteActivity extends AppCompatActivity {

    private static final String TAG = "NoteActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        if (getIntent().hasExtra("selected_note")) {
            Note note = getIntent().getParcelableExtra("selected_note");
            Log.d(TAG, "onCreate: " + note.toString());
        }
    }
}