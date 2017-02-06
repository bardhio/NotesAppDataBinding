package io.bardh.notetakingapp.showNotes;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import io.bardh.notetakingapp.R;
import io.bardh.notetakingapp.databinding.ActivityMainBinding;
import io.bardh.notetakingapp.editNote.NoteModel;
import io.bardh.notetakingapp.editNote.NotesRecyclerViewAdapter;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;
  private MainAcitvityViewModel viewModel;
  private ArrayList<NoteModel> list;
  NotesRecyclerViewAdapter adapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    viewModel = new MainAcitvityViewModel(this);
    binding.setViewModel(viewModel);
    updateUi();
  }
  private void updateUi(){
    list = new ArrayList<>();
    Realm.init(this);
    Realm realm = Realm.getDefaultInstance();
    RealmQuery<NoteModel> query = realm.where(NoteModel.class);
    RealmResults<NoteModel> result1 = query.findAll();
    for(int i=0;i<result1.size();i++){
      list.add(new NoteModel(result1.get(i).getDescription()));
    }

    adapter = new NotesRecyclerViewAdapter(list,this);
    LinearLayoutManager linearLayoutManager = new GridLayoutManager(this,2);
    binding.notesRecyclerview.setHasFixedSize(true);
    binding.notesRecyclerview.setLayoutManager(linearLayoutManager);
    binding.notesRecyclerview.setAdapter(adapter);
  }

  @Override
  protected void onResume() {
    super.onResume();
    updateUi();

  }
}
