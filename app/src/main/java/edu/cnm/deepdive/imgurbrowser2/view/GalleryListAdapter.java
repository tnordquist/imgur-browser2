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
import edu.cnm.deepdive.imgurbrowser2.model.Gallery;
import edu.cnm.deepdive.imgurbrowser2.model.Image;
import java.util.ArrayList;
import java.util.List;

public class GalleryListAdapter extends
    RecyclerView.Adapter<GalleryListAdapter.GalleryViewHolder> {

  private final Context context;
  private final List<Gallery> galleries;
  private final OnItemSelectedHelper onItemSelectedHelper;

  public GalleryListAdapter(Context context, List<Gallery> galleries,
      OnItemSelectedHelper onItemSelectedHelper) {
    super();
    this.context = context;
    this.galleries = galleries;
    this.onItemSelectedHelper = onItemSelectedHelper;
  }

  @NonNull
  @Override
  public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_gallery_search, parent, false);
    return new GalleryViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return galleries.size();
  }

  class GalleryViewHolder extends RecyclerView.ViewHolder implements OnItemSelectedListener {

    private final TextView title;
    private final TextView description;
    private final Spinner imageSpinner;

    private Gallery gallery;
    public List<Image> withIconList = new ArrayList<>();
//    private final Image galleryIcon = new Image("https://images.app.goo.gl/ajLDeNXUJWuerkmh9");
    private boolean handleSelection;

    public GalleryViewHolder(@NonNull View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.title);
      description = itemView.findViewById(R.id.description);
      imageSpinner = itemView.findViewById(R.id.gallery_search_spinner);
    }

    private void bind(int position) {
      gallery = galleries.get(position);
      title.setText(gallery.getTitle());
      description.setText(gallery.getDescription());
      GalleryImageAdapter galleryImageAdapter = new GalleryImageAdapter(context,
          gallery.getImages() /*withIconList possibly instead*/);
      imageSpinner.setAdapter(galleryImageAdapter);
      handleSelection = false;
      imageSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      if (handleSelection) {
        onItemSelectedHelper.onSelected(gallery, gallery.getImages().get(0));
      } else {
        handleSelection = true;
      }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
  }

  public interface OnItemSelectedHelper {

    void onSelected(Gallery gallery, Image image);
  }

}
