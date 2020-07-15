package edu.cnm.deepdive.imgurbrowser2.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.imgurbrowser2.BuildConfig;
import edu.cnm.deepdive.imgurbrowser2.model.Gallery;
import edu.cnm.deepdive.imgurbrowser2.service.ImgurService;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends AndroidViewModel {

  private final MutableLiveData<Gallery.Search> searchResult;
  private final MutableLiveData<Throwable> throwable;
  ImgurService imgurService;
  private final CompositeDisposable pending;

  public ListViewModel(@NonNull Application application) {
    super(application);
    searchResult = new MutableLiveData<Gallery.Search>();
    throwable = new MutableLiveData<Throwable>();
    imgurService = ImgurService.getInstance();
    pending = new CompositeDisposable();
    loadData();
  }

  public LiveData<Gallery.Search> getSearchResult() {
    return searchResult;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void loadData() {
    pending.add(
        imgurService.getSearchResult(BuildConfig.CLIENT_ID,
            "Fish AND Sharks")
            .subscribeOn(Schedulers.io())
            .subscribe(
                value -> this.searchResult.postValue(value),
                throwable -> this.throwable.postValue(throwable.getCause())
            )
    );
  }

  @Override
  protected void onCleared() {
    super.onCleared();
    pending.clear();
  }

}
