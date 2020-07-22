package edu.cnm.deepdive.imgurbrowser2.controller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import edu.cnm.deepdive.imgurbrowser2.R;
import edu.cnm.deepdive.imgurbrowser2.model.Gallery.Search;
import edu.cnm.deepdive.imgurbrowser2.viewmodel.ListViewModel;

public class MainActivity extends AppCompatActivity {

  private NavController navController;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    navController = Navigation.findNavController(this,R.id.fragment);
    NavigationUI.setupActionBarWithNavController(this,navController);
  }

  @Override
  public boolean onSupportNavigateUp() {
    return NavigationUI.navigateUp(navController, (DrawerLayout) null);
  }
}
