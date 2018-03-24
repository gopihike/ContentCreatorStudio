package com.hackathon.contentcreatorstudio.contentstudio.datamodels;

import com.hackathon.contentcreatorstudio.contentstudio.interfaces.IContentThemeDM;
import com.hackathon.contentcreatorstudio.contentstudio.models.ContentStudioBackground;
import com.hackathon.contentcreatorstudio.contentstudio.models.ContentStudioThemeCategory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by gopi on 24/03/18.
 */

public class ContentThemeDiskDM implements IContentThemeDM {

    @Override
    public Observable<List<ContentStudioThemeCategory>> getThemeData() {
        return Observable.create(new ObservableOnSubscribe<List<ContentStudioThemeCategory>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ContentStudioThemeCategory>> e) throws Exception {
                List<ContentStudioThemeCategory> themeDataList = getThemeDataOfDisk();
                e.onNext(themeDataList);
                e.onComplete();
            }
        }).observeOn(Schedulers.io()).subscribeOn(Schedulers.computation());
    }

    private List<ContentStudioThemeCategory> getThemeDataOfDisk() {
        List<ContentStudioThemeCategory> categoryList = new ArrayList<>();

        List<ContentStudioBackground> bglist = new ArrayList<>();
        bglist.add(new ContentStudioBackground("bg1", ""));
        bglist.add(new ContentStudioBackground("bg2", ""));
        bglist.add(new ContentStudioBackground("bg3", ""));
        bglist.add(new ContentStudioBackground("bg4", ""));
        categoryList.add(new ContentStudioThemeCategory("News Room", "", bglist));


        bglist = new ArrayList<>();
        bglist.add(new ContentStudioBackground("bg11", ""));
        bglist.add(new ContentStudioBackground("bg21", ""));
        bglist.add(new ContentStudioBackground("bg31", ""));
        bglist.add(new ContentStudioBackground("bg41", ""));
        categoryList.add(new ContentStudioThemeCategory("News Room", "", bglist));
        return categoryList;
    }
}
