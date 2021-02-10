package edu.cnm.deepdive.imgurbrowser2.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.imgurbrowser2.databinding.GalleryListBinding;
import edu.cnm.deepdive.imgurbrowser2.model.Gallery;
import edu.cnm.deepdive.imgurbrowser2.model.Image;
import edu.cnm.deepdive.imgurbrowser2.view.GalleryListAdapter;
import edu.cnm.deepdive.imgurbrowser2.view.GalleryListAdapter.OnItemSelectedHelper;
import edu.cnm.deepdive.imgurbrowser2.viewmodel.ListViewModel;

public class GallerySearchFragment extends Fragment implements OnItemSelectedHelper {

  private ListViewModel viewModel;
  private GalleryListBinding binding;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    binding = GalleryListBinding.inflate(inflater);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity())
        .get(ListViewModel.class);
    viewModel.getGalleries().observe(getViewLifecycleOwner(), galleries -> {
      if (galleries != null) {
        binding.recyclerView.setAdapter(new GalleryListAdapter(getContext(), galleries,
            this));
      }
    });
  }

  @Override
  public void onSelected(Gallery gallery, Image image) {
    ImageDetailDialogFragment fragment = ImageDetailDialogFragment.newInstance(image);
    fragment.show(getChildFragmentManager(), fragment.getClass().getName());
  }
}
