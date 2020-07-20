package edu.cnm.deepdive.imgurbrowser2;

import android.app.Application;
import com.squareup.picasso.Picasso;

public class ImgurApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Picasso.setSingletonInstance(
        new Picasso.Builder(this)
        .loggingEnabled(true)
        .build()
    );
  }
}
