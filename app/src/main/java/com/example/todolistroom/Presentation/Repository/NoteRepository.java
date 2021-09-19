package com.example.todolistroom.Presentation.Repository;


import android.content.Context;

import com.example.todolistroom.Presentation.Repository.Room.NoteDatabase;

public class NoteRepository {
    private NoteDatabase mNoteDatabase;

    public NoteRepository(Context context) {
        mNoteDatabase = NoteDatabase.getInstance(context);
    }
}
