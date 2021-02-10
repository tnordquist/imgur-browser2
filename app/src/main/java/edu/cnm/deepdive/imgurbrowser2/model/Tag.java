package edu.cnm.deepdive.imgurbrowser2.model;

import com.google.gson.annotations.*;

public class Tag {

  @Expose
  private String name;

  @SerializedName("display_name")
  @Expose
  private String displayName;

  @Expose
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
