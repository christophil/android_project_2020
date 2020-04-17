package com.example.sportapp.camera;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sportapp.R;
import com.example.sportapp.config.ConfigManager;
import com.example.sportapp.config.DefaultActivity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CameraActivity extends DefaultActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Bitmap mImageBitmap;
    private String mCurrentPhotoPath;

    private LinearLayout layout;
    private CameraCameraFragment cameraFragment;
    private CameraGalleryFragment galleryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        layout = findViewById(R.id.linearlayout_camera);

        this.cameraFragment = CameraCameraFragment.newInstance();
        this.galleryFragment = CameraGalleryFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.camera_container, cameraFragment)
                .replace(R.id.gallery_container, galleryFragment)
                .commit();

        ConfigManager.setOrientation(this, layout);



    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if(this.cameraFragment.getButton() != null){
            this.cameraFragment.getButton().setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                    File photoDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                    try {
                        File photoFile = File.createTempFile("photo"+time, ".jpg", photoDir);
                        mCurrentPhotoPath = photoFile.getAbsolutePath();

                        Uri photoUri = FileProvider.getUriForFile(CameraActivity.this, CameraActivity.this.getApplicationContext().getPackageName() + ".provider", photoFile);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        if(this.galleryFragment.getButton() != null){
            this.galleryFragment.getButton().setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(android.content.Intent.ACTION_VIEW);
                    intent.setType("image/*");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){

            mImageBitmap = BitmapFactory.decodeFile(mCurrentPhotoPath);
            MediaStore.Images.Media.insertImage(getContentResolver(), mImageBitmap, "picture", "description");
        }
    }
}
