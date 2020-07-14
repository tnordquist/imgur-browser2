package edu.cnm.deepdive.imgurbrowser2.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import edu.cnm.deepdive.imgurbrowser2.R;
import edu.cnm.deepdive.imgurbrowser2.model.Gallery;
import edu.cnm.deepdive.imgurbrowser2.model.Gallery.Search;
import edu.cnm.deepdive.imgurbrowser2.viewmodel.ListViewModel;

public class MainActivity extends AppCompatActivity {

  ListViewModel listViewModel;
  private NavController navController;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
//
//    listViewModel = new ViewModelProvider(this)
//        .get(ListViewModel.class);
//    getLifecycle().addObserver(listViewModel);
//    listViewModel.getSearchResult().observe(this, new Observer<Search>() {
//      @Override
//      public void onChanged(Search search) {
//        listViewModel.loadData();
//      }
//    });

//    navController = Navigation.findNavController(this,R.id.fragment);
//    NavigationUI.setupActionBarWithNavController(this,navController);
//  }

//  @Override
//  public boolean onSupportNavigateUp() {
//    return NavigationUI.navigateUp(navController, (DrawerLayout) null);
  }
}
