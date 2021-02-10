package edu.cnm.deepdive.imgurbrowser2;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.imgurbrowser2.R;
import edu.cnm.deepdive.imgurbrowser2.databinding.ActivityMainBinding;
import edu.cnm.deepdive.imgurbrowser2.model.Gallery.Search;
import edu.cnm.deepdive.imgurbrowser2.viewmodel.ListViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    View view = binding.getRoot();
    setContentView(view);

  }
}
