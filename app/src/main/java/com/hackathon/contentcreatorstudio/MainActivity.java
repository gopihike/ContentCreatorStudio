package com.hackathon.contentcreatorstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hackathon.contentcreatorstudio.activities.BasicCameraActivity;
import com.hackathon.contentcreatorstudio.contentstudio.activities.ContentStudioActivity;
import com.hackathon.contentcreatorstudio.nativejni.ContentStudioJNI;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        findViewById(R.id.sample_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContentStudioActivity.class);
                startActivity(intent);
            }
        });
    }


}
