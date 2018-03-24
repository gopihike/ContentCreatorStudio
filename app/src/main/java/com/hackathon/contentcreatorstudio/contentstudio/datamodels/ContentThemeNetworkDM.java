package com.hackathon.contentcreatorstudio.contentstudio.datamodels;

import com.hackathon.contentcreatorstudio.contentstudio.interfaces.IContentThemeDM;
import com.hackathon.contentcreatorstudio.contentstudio.models.ContentStudioThemeCategory;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by gopi on 24/03/18.
 */

public class ContentThemeNetworkDM implements IContentThemeDM {

    @Override
    public Observable<List<ContentStudioThemeCategory>> getThemeData() {
        return null;
    }
}
