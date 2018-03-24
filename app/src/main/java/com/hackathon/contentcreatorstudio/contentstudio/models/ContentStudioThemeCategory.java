package com.hackathon.contentcreatorstudio.contentstudio.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gopi on 24/03/18.
 */

public class ContentStudioThemeCategory {

    public String title;
    public String imageUrl;
    public List<ContentStudioBackground> backgroundList = new ArrayList<>();

    public ContentStudioThemeCategory() {
    }

    public ContentStudioThemeCategory(String title, String imageUrl, List<ContentStudioBackground> backgroundList) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.backgroundList = backgroundList;
    }
}
