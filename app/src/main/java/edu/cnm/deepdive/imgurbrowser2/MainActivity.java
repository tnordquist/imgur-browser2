package edu.cnm.deepdive.imgurbrowser2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.imgurbrowser2.R;
import edu.cnm.deepdive.imgurbrowser2.model.Gallery.Search;
import edu.cnm.deepdive.imgurbrowser2.viewmodel.ListViewModel;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }
}
