package io.bardh.notetakingapp.editNote;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.bardh.notetakingapp.R;
import io.bardh.notetakingapp.databinding.NoteLayoutBinding;

/**
 * Created by bardhshasivari on 2/6/17.
 */

public class NotesRecyclerViewAdapter extends RecyclerView.Adapter<NotesViewHolder> {
  private ArrayList<NoteModel> list;
  private Context mContext;

  public NotesRecyclerViewAdapter(ArrayList<NoteModel> list, Context mContext) {
    this.list = list;
    this.mContext = mContext;
  }

  @Override
  public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(mContext);
    NoteLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.note_layout,parent,false);
    return new NotesViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(NotesViewHolder holder, int position) {
    holder.bind(list.get(position));


  }

  @Override
  public int getItemCount() {
    return list.size();
  }
}
