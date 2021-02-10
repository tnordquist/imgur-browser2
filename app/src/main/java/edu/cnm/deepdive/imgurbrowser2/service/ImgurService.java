package edu.cnm.deepdive.imgurbrowser2.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.imgurbrowser2.BuildConfig;
import edu.cnm.deepdive.imgurbrowser2.model.Gallery;
import io.reactivex.Single;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ImgurService {

  @GET("gallery/search")
  Single<Gallery.Search> getSearchResult(
      @Header("Authorization") String authHeader, @Query("q") String subject);

  static ImgurService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  class InstanceHolder {

    private static final ImgurService INSTANCE;

    static {
      Gson gson = new GsonBuilder()
          .create();
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .readTimeout(30, TimeUnit.SECONDS)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(client)
          .baseUrl(BuildConfig.BASE_URL)
          .build();
      INSTANCE = retrofit.create(ImgurService.class);
    }

  }

}
