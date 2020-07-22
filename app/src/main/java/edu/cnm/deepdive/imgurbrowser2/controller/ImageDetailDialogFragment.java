package edu.cnm.deepdive.imgurbrowser2.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.imgurbrowser2.R;
import edu.cnm.deepdive.imgurbrowser2.model.Image;
import edu.cnm.deepdive.imgurbrowser2.view.GalleryImageAdapter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ImageDetailDialogFragment extends DialogFragment {

  private AlertDialog dialog;
  private View root;
  private TextView title;
  private TextView description;
  private TextView imageId;
  private TextView imageUrl;
  private TextView imageDateTime;
  private TextView imageType;
  private TextView imageWidth;
  private TextView imageHeight;
  private TextView imageViews;
  private TextView imageBandWidth;

  private List<Image> images;
  private GalleryImageAdapter adapter;
  private Image image;

  public static ImageDetailDialogFragment newInstance(Image image) {
    ImageDetailDialogFragment fragment = new ImageDetailDialogFragment();
    Bundle args = new Bundle();
    args.putSerializable("image", image);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      image = (Image) getArguments().getSerializable("image");
    }
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    root = LayoutInflater.from(getContext())
        .inflate(R.layout.fragment_image_detail_dialog, null, false);
    ImageView imageView = root.findViewById(R.id.image_detail);
    title = root.findViewById(R.id.image_title);
    description = root.findViewById(R.id.image_description);
    imageId = root.findViewById(R.id.image_id);
    imageUrl = root.findViewById(R.id.image_url);
    imageDateTime = root.findViewById(R.id.image_datetime);
    imageType = root.findViewById(R.id.image_type);
    imageWidth = root.findViewById(R.id.image_width);
    imageHeight = root.findViewById(R.id.image_height);
    imageViews = root.findViewById(R.id.image_views);
    imageBandWidth = root.findViewById(R.id.image_bandwidth);

    if (image.getUrl() != null) {
      Picasso.get().load(image.getUrl()).into(imageView);
    }
    title.setText((image.getTitle() != null) ? image.getTitle() : "Title Not Available");
    description.setText((image.getDescription() != null) ? image.getDescription() : "Description N/A");
    imageId.setText((image.getImageId() != null) ? "Id: " + image.getImageId() : "Image Id N/A");
    imageUrl.setText((image.getUrl() != null) ? image.getUrl() : "Url N/A");
    imageDateTime.setText((image.getImageDateTime() != null) ? "Date: " + (convertTime(image.getImageDateTime())) : "DateTime N/A");
    imageType.setText((image.getType() != null) ? image.getType() : "Image Type N/A");
    imageWidth.setText((image.getWidth() != null) ? "Width: " + (image.getWidth()) : "Image Width N/A");
    imageHeight.setText((image.getDescription() != null) ? "Height: " + (image.getHeight()) : "Image Height N/A");
    imageViews.setText((image.getViews() != null) ? "Views: " + (image.getViews()) : "Number of Views N/A");
    imageBandWidth.setText((image.getBandwidth() != null) ? "Bandwidth: " + (image.getBandwidth()) : "Bandwidth N/A");
    dialog = new AlertDialog.Builder(Objects.requireNonNull(getContext()))
        .setView(root)
        .create();
    return dialog;
  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        return null;
    }

    public String convertTime(long time) {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        return format.format(date);
    }
}
