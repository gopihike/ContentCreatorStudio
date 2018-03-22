package com.hackathon.contentcreatorstudio.activities;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.hackathon.contentcreatorstudio.R;
import com.hackathon.contentcreatorstudio.helpers.CameraPreview;
import com.hackathon.contentcreatorstudio.utils.CameraUtils;

import java.io.File;
import java.io.FileOutputStream;

//import android.hardware.camera2;


public class BasicCameraActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout camPreviewFrame;
    private Camera camera;
    CameraPreview cameraPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_camera);
        init();
        doProcess();
    }

    private void init() {
        findViewById(R.id.cam_takepic_btn).setOnClickListener(this);
        camPreviewFrame = (FrameLayout) findViewById(R.id.cam_preview_frame);
        cameraPreview = new CameraPreview(this, getCameraInstance());
        camPreviewFrame.addView(cameraPreview);
//        camera = cameraPreview.mCamera;
    }

    private void doProcess() {
    }

    private void takePhoto() {
//        Camera cameraInstance = camera;
//        camera.startPreview();
        camera.takePicture(null, null, (byte[] data, Camera camInstance) -> {
            File outPutFile = CameraUtils.getOutputMediaFile();
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(outPutFile);
                fileOutputStream.write(data);
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
//            camera.stopPreview();
//            camera.release();
//            camera = null;
        });
    }

    private Camera getCameraInstance() {
        if (!CameraUtils.checkCameraHardware(getApplicationContext())) {
            return null;
        }
        if (camera == null) {
           /* int count = Camera.getNumberOfCameras();
                        List<Descriptor> result = new ArrayList<AudioEffect.Descriptor>();
                        Camera.CameraInfo info = new Camera.CameraInfo();
                        for (int cameraId = 0; cameraId < count; cameraId++) {
                            Camera.getCameraInfo(cameraId, info);
                            Descriptor descriptor = new Descriptor(cameraId, info);
                            Camera camera = Camera.open(descriptor.getCameraId());*/
            camera = Camera.open(0);
        }
        return camera;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cam_takepic_btn:
                takePhoto();
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();   // some problem on doing these that after release you shouldn't use the camera object . else exception.
       /* try {
            camera.release();
            cameraPreview.getHolder().removeCallback(cameraPreview);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*try {
            if (camera != null) {
                camera = Camera.open();
//                camera.reconnect();
                cameraPreview.getHolder().addCallback(cameraPreview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}