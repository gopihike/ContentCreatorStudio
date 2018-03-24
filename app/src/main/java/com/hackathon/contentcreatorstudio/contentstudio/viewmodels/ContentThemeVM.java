package com.hackathon.contentcreatorstudio.contentstudio.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.hackathon.contentcreatorstudio.contentstudio.models.ContentStudioThemeCategory;
import com.hackathon.contentcreatorstudio.contentstudio.repository.ContentThemeRepository;

import java.util.List;
import java.util.Observable;

import io.reactivex.functions.Consumer;

/**
 * Created by gopi on 24/03/18.
 */

public class ContentThemeVM extends ViewModel {

    public MutableLiveData<List<ContentStudioThemeCategory>> contentThemeLiveData;
    private ContentThemeRepository repository;

    public ContentThemeVM() {
        contentThemeLiveData = new MutableLiveData<>();
        repository = new ContentThemeRepository();
    }

    public void getContentThemeData() {
        repository.getThemeData().subscribe(new Consumer<List<ContentStudioThemeCategory>>() {
            @Override
            public void accept(List<ContentStudioThemeCategory> contentStudioThemeCategories) throws Exception {
                contentThemeLiveData.postValue(contentStudioThemeCategories);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                contentThemeLiveData.postValue(null);
            }
        });
    }

}
