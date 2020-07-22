package edu.cnm.deepdive.imgurbrowser2.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.imgurbrowser2.R;
import edu.cnm.deepdive.imgurbrowser2.model.Image;
import java.util.List;

public class GalleryImageAdapter extends ArrayAdapter<Image> {

  public GalleryImageAdapter(@NonNull Context context, List<Image> imageItemArray) {
    super(context, 0, imageItemArray);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    return initView(position, convertView, parent);
  }

  @Nullable
  @Override
  public View getDropDownView(int position, @Nullable View convertView,
      @NonNull ViewGroup parent) {
    return initView(position, convertView, parent);
  }

  private View initView(int position, View convertview, ViewGroup parent) {
    if (convertview == null) {
      convertview = LayoutInflater.from(getContext()).inflate(
          R.layout.custom_gallery_search_spinner_item, parent, false
      );
    }
    ImageView imageView = convertview.findViewById(R.id.image_gallery_search);
    TextView titleView = convertview.findViewById(R.id.title);
    TextView descriptionView = convertview.findViewById(R.id.description);
    TextView urlView = convertview.findViewById(R.id.url);

    Image currentItem = getItem(position);

    if (currentItem.getUrl() != null) {
      Picasso.get().load(currentItem.getUrl()).into(imageView);
      urlView.setText(currentItem.getUrl());
    }
    if (currentItem.getTitle() != null) {
      titleView.setText(currentItem.getTitle());
    }
    if (currentItem.getDescription() != null) {
      descriptionView.setText(currentItem.getDescription());
    }

    return convertview;
  }
}