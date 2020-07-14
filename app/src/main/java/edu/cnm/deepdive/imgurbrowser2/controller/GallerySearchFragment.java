package edu.cnm.deepdive.imgurbrowser2.controller;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.imgurbrowser2.R;
import edu.cnm.deepdive.imgurbrowser2.model.Gallery;
import edu.cnm.deepdive.imgurbrowser2.model.Gallery.Search;
import edu.cnm.deepdive.imgurbrowser2.view.GalleryListAdapter;
import edu.cnm.deepdive.imgurbrowser2.viewmodel.ListViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GallerySearchFragment extends Fragment {

  private ListViewModel viewModel;
  private GalleryListAdapter galleryListAdapter;
  private ProgressBar loadingView;
  private TextView listError;
  private RecyclerView galleryArray;

  private Gallery[] galleries;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.gallery_list, container, false);
    galleryArray = view.findViewById(R.id.recycler_view);

    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(Objects.requireNonNull(getActivity()))
        .get(ListViewModel.class);
    viewModel.getSearchResult().observe(getViewLifecycleOwner(), new Observer<Search>() {
      @Override
      public void onChanged(Search searchResult) {
        if (searchResult != null) {
          galleryArray.setVisibility(View.VISIBLE);
          galleryArray.setAdapter(new GalleryListAdapter(GallerySearchFragment.this.getContext(),
              searchResult.getData()));
        }
      }
    });
    viewModel.getLoading().observe(getViewLifecycleOwner(), loading -> {
      loadingView.setVisibility(loading ? View.VISIBLE : View.GONE);
      if (loading) {
        listError.setVisibility(View.GONE);
        galleryArray.setVisibility(View.GONE);
      }
    });

    viewModel.getError().observe(getViewLifecycleOwner(), error -> {
      listError.setVisibility(error ? View.VISIBLE : View.GONE);
    });
  }

}
