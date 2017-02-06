package io.bardh.notetakingapp.editNote;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.bardh.notetakingapp.R;
import io.bardh.notetakingapp.databinding.ActivityEditNoteBinding;

public class EditNoteActivity extends AppCompatActivity {
  private ActivityEditNoteBinding binding;
  private EditNotesViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_note);
    viewModel = new EditNotesViewModel(this,binding);
    binding.setViewModel(viewModel);
  }
}
