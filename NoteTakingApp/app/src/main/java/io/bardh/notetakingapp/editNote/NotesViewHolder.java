package io.bardh.notetakingapp.editNote;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import io.bardh.notetakingapp.databinding.NoteLayoutBinding;

/**
 * Created by bardhshasivari on 2/6/17.
 */

public class NotesViewHolder extends RecyclerView.ViewHolder {
  private EditNotesViewModel mViewModel;
  private NoteLayoutBinding mBinding;
  private NoteModel mNoteModel;
  public NotesViewHolder(NoteLayoutBinding binding) {
    super(binding.getRoot());
    mBinding = binding;
    mViewModel = new EditNotesViewModel(binding.getRoot().getContext());
    mBinding.setViewModel(mViewModel);
  }
  public void bind(NoteModel noteModel){
    mNoteModel = noteModel;
    mViewModel.setmNoteModel(noteModel);
    mBinding.executePendingBindings();
  }
}
