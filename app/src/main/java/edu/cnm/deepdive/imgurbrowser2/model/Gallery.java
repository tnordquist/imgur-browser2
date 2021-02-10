package edu.cnm.deepdive.imgurbrowser2.model;

import java.util.Arrays;
import java.util.List;
import com.google.gson.annotations.*;

public class Gallery {

  private String id;

  @Expose
  private String title;

  @Expose
  private String description;

  private long datetime;

  @SerializedName("images_count")
  @Expose
  private int imagesCount;

  @Expose
  private Tag[] tags;

  @Expose
  private List<Image> images;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getDatetime() {
    return datetime;
  }

  public void setDatetime(long datetime) {
    this.datetime = datetime;
  }

  public int getImagesCount() {
    return imagesCount;
  }

  public void setImagesCount(int imagesCount) {
    this.imagesCount = imagesCount;
  }

  public Tag[] getTags() {
    return tags;
  }

  public void setTags(Tag[] tags) {
    this.tags = tags;
  }

  public List<Image> getImages() {
//    return (images != null) ? images : new List<Image>() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }

//  @Override
//  public String toString() {
//    return title + description + images.toString();
//  }

  public static class Search {

    @Expose
    private List<Gallery> data;

    public List<Gallery> getData() {
      return data;
    }

    public void setData(List<Gallery> data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "SearchResult{" +
          "data=" + data.toString();
    }
  }

}
