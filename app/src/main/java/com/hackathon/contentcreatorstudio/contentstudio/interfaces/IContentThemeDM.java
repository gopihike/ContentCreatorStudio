package com.hackathon.contentcreatorstudio.contentstudio.interfaces;

import android.databinding.ObservableList;

import com.hackathon.contentcreatorstudio.contentstudio.models.ContentStudioThemeCategory;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by gopi on 24/03/18.
 */

public interface IContentThemeDM {
    Observable<List<ContentStudioThemeCategory>> getThemeData();
}
