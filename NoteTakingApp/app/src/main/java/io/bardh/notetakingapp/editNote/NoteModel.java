package io.bardh.notetakingapp.editNote;

import android.databinding.BaseObservable;

import io.realm.RealmObject;

/**
 * Created by bardhshasivari on 2/6/17.
 */

public class NoteModel extends RealmObject {
  private String description;

  public NoteModel(String description) {
    this.description = description;
  }

  public NoteModel() {
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


}
