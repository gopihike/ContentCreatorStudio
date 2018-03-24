package com.hackathon.contentcreatorstudio.contentstudio.repository;

import com.hackathon.contentcreatorstudio.contentstudio.datamodels.ContentThemeDiskDM;
import com.hackathon.contentcreatorstudio.contentstudio.interfaces.IContentThemeDM;
import com.hackathon.contentcreatorstudio.contentstudio.models.ContentStudioThemeCategory;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by gopi on 24/03/18.
 */

public class ContentThemeRepository {
    private IContentThemeDM iContentThemeDM;

    public ContentThemeRepository() {
        iContentThemeDM = new ContentThemeDiskDM();
    }

    public Observable<List<ContentStudioThemeCategory>> getThemeData() {
        return Observable.create(new ObservableOnSubscribe<List<ContentStudioThemeCategory>>() {
            @Override
            public void subscribe(final ObservableEmitter<List<ContentStudioThemeCategory>> emitter) throws Exception {
                iContentThemeDM.getThemeData().subscribe(new Consumer<List<ContentStudioThemeCategory>>() {
                    @Override
                    public void accept(List<ContentStudioThemeCategory> contentStudioThemeCategories) throws Exception {
                        emitter.onNext(contentStudioThemeCategories);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        emitter.onNext(null);
                    }
                });
            }
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation());
    }

}
