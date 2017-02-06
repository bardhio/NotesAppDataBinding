package io.bardh.notetakingapp.editNote;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;

import io.bardh.notetakingapp.databinding.ActivityEditNoteBinding;
import io.bardh.notetakingapp.databinding.NoteLayoutBinding;
import io.realm.Realm;

/**
 * Created by bardhshasivari on 2/4/17.
 */

public class EditNotesViewModel extends BaseObservable {
  private Context mContext;
  public NoteModel mNoteModel;
  public ActivityEditNoteBinding binding;

  public EditNotesViewModel(Context mContext) {
    this.mContext = mContext;
  }

  public void setmNoteModel(NoteModel mNoteModel) {
    this.mNoteModel = mNoteModel;
    notifyChange();
  }

  public EditNotesViewModel(Context mContext, ActivityEditNoteBinding binding) {
    this.mContext = mContext;
    this.binding = binding;
  }

  public void saveNote(){
    //((Activity)mContext).finish();
    Realm.init(mContext);
    Realm realm = Realm.getDefaultInstance();
    realm.executeTransactionAsync(new Realm.Transaction() {
      @Override
      public void execute(Realm realm) {
        NoteModel noteModel = realm.createObject(NoteModel.class);
        noteModel.setDescription(binding.editNote.getText().toString());

      }
    }, new Realm.Transaction.OnSuccess() {
      @Override
      public void onSuccess() {
        // Transaction was a success.
        ((Activity)mContext).finish();
      }
    }, new Realm.Transaction.OnError() {
      @Override
      public void onError(Throwable error) {
        // Transaction failed and was automatically canceled.
        Toast.makeText(mContext, "An error ecurred please try again!", Toast.LENGTH_SHORT).show();
      }
    });

  }

  @Bindable public String getDescription(){return mNoteModel.getDescription();}

}
