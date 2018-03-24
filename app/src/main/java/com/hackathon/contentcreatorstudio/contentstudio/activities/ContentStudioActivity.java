package com.hackathon.contentcreatorstudio.contentstudio.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hackathon.contentcreatorstudio.R;
import com.hackathon.contentcreatorstudio.contentstudio.fragments.ContentStudioThemeFragment;

public class ContentStudioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_studio);
        initLogic();
    }

    private void initLogic() {
        ContentStudioThemeFragment fragment = new ContentStudioThemeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.theme_fragment, fragment, "contentFragment").commitAllowingStateLoss();
    }
}
