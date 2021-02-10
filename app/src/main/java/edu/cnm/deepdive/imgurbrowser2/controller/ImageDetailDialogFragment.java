package edu.cnm.deepdive.imgurbrowser2.controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.imgurbrowser2.R;
import edu.cnm.deepdive.imgurbrowser2.databinding.FragmentImageDetailDialogBinding;
import edu.cnm.deepdive.imgurbrowser2.model.Image;

public class ImageDetailDialogFragment extends DialogFragment {

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

    FragmentImageDetailDialogBinding binding
        = FragmentImageDetailDialogBinding.inflate(LayoutInflater.from(getContext()));

    if (image.getUrl() != null) {
      Picasso.get().load(image.getUrl()).into(binding.imageDetail);
    }
    binding.imageDescription
        .setText((image.getDescription() != null) ? image.getDescription() : "Description N/A");
    binding.imageId
        .setText((image.getImageId() != null) ? "Id: " + image.getImageId() : "Image Id N/A");
    binding.imageUrl.setText((image.getUrl() != null) ? "Image Url: " + image.getUrl() : "Url N/A");
    binding.imageDatetime.setText(
        (image.getImageDateTime() != null) ? "Submitted: " + convertTime(image.getImageDateTime())
            : "DateTime N/A");
    binding.imageType
        .setText((image.getType() != null) ? "Type of Image: " + image.getType() : "Type N/A");
    binding.imageWidth.setText(
        (image.getWidth() != null) ? "Image Width: " + image.getWidth() : "Image Width N/A");
    binding.imageHeight.setText(
        (image.getHeight() != null) ? "Image Height: " + image.getHeight() : "Image Height N/A");
    binding.imageViews
        .setText((image.getViews() != null) ? "Views: " + image.getViews() : "Views N/A");
    binding.imageBandwidth.setText(
        (image.getBandwidth() != null) ? "Bandwidth: " + image.getBandwidth() : "Bandwidth N/A");

    return new AlertDialog.Builder(getContext())
        .setTitle((image.getTitle() != null) ? image.getTitle() : "Untitled")
        .setView(binding.getRoot())
        .setPositiveButton(R.string.close_image_dialog, (dlg, which) -> {
        })
        .create();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return null;
  }

  private String convertTime(long epoch) {
    return new java.text.SimpleDateFormat("MMMM-dd-yyyy hh:mm aa z")
        .format(new java.util.Date(epoch * 1000));
  }
}
