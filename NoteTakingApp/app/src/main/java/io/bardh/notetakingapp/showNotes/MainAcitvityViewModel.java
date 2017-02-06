package io.bardh.notetakingapp.showNotes;

import android.content.Context;
import android.content.Intent;

import io.bardh.notetakingapp.editNote.EditNoteActivity;

/**
 * Created by bardhshasivari on 2/4/17.
 */

public class MainAcitvityViewModel {
  private Context mContext;

  public MainAcitvityViewModel(Context mContext) {
    this.mContext = mContext;
  }

  public void addNote() {
    Intent intent = new Intent(mContext,EditNoteActivity.class);
    mContext.startActivity(intent);

  }
}
