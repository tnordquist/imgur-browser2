package edu.cnm.deepdive.imgurbrowser2.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.imgurbrowser2.R;
import edu.cnm.deepdive.imgurbrowser2.databinding.ItemGallerySearchBinding;
import edu.cnm.deepdive.imgurbrowser2.model.Gallery;
import edu.cnm.deepdive.imgurbrowser2.model.Image;
import java.util.ArrayList;
import java.util.List;

public class GalleryListAdapter extends
    RecyclerView.Adapter<GalleryListAdapter.GalleryViewHolder> {

  private final Context context;
  private final List<Gallery> galleries;
  private final OnItemSelectedHelper onItemSelectedHelper;
  private ItemGallerySearchBinding binding;

  public GalleryListAdapter(Context context, List<Gallery> galleries,
      OnItemSelectedHelper onItemSelectedHelper) {
    super();
    this.context = context;
    this.galleries = galleries;
    this.onItemSelectedHelper = onItemSelectedHelper;
  }

  @NonNull
  @Override
  public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
      int viewType) {
    binding = ItemGallerySearchBinding.inflate(LayoutInflater.from(context), parent, false);
    return new GalleryViewHolder(binding.getRoot());
  }

  @Override
  public void onBindViewHolder(@NonNull GalleryListAdapter.GalleryViewHolder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return galleries.size();
  }

  class GalleryViewHolder extends RecyclerView.ViewHolder implements OnItemSelectedListener {

    private Gallery gallery;
    private final List<Image> withIconList = new ArrayList<>();
    private final String imageUrl = "" + R.drawable.gallery;
    private final Image galleryIcon = new Image(imageUrl);

    public GalleryViewHolder(@NonNull View itemView) {
      super(itemView);
    }

    private void bind(int position) {
      gallery = galleries.get(position);
      withIconList.clear();
      withIconList.add(galleryIcon);
      withIconList.addAll(gallery.getImages());
      binding.galleryTitle.setText(gallery.getTitle());
      binding.galleryDescription.setText(gallery.getDescription());
      GalleryImageAdapter galleryImageAdapter = new GalleryImageAdapter(context,
          withIconList);
      binding.gallerySearchSpinner.setAdapter(galleryImageAdapter);
      binding.gallerySearchSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
      if (position > 0) {
        onItemSelectedHelper.onSelected(gallery, gallery.getImages().get(position - 1));
        adapterView.setSelection(0);
      }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
  }

  public interface OnItemSelectedHelper {

    void onSelected(Gallery gallery, Image image);
  }

}
