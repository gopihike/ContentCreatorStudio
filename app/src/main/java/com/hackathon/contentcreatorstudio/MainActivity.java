package com.hackathon.contentcreatorstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hackathon.contentcreatorstudio.activities.BasicCameraActivity;
import com.hackathon.contentcreatorstudio.nativejni.ContentStudioJNI;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        findViewById(R.id.sample_text).setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, BasicCameraActivity.class);
            startActivity(intent);
        });
    }


}
