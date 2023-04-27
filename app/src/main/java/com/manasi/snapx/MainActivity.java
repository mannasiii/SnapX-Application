package com.manasi.snapx;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.manasi.snapx.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Button button;

    ActivityMainBinding binding;

    public static Uri imgUri;

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        button = (Button) findViewById(R.id.button);
        binding=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(MainActivity.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        //.galleryOnly()	//User can only select image from Gallery
                        //.cameraOnly()	//User can only capture image using Camera
                        //.crop(16f, 9f)	//Crop image with 16:9 aspect ratio
                        // .cropSquare()	//Crop square image, its same as crop(1f, 1f)
                        .compress(1024)	//Final image size will be less than 1 MB
                        .maxResultSize(620, 620)	//Final image resolution will be less than 620 x 620
//                        .setImageProviderInterceptor { imageProvider -> //Intercept ImageProvider
//                        Log.d("ImagePicker", "Selected ImageProvider: "+imageProvider.name)
//                }
                        //.setDismissListener {
                        // Handle dismiss event
                        ////  Log.d("ImagePicker", "onDismiss");
                        //}
                        .start();

            }
            ;});}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Uri Uri= data.getData();
        //cover.setImageURI(Uri);

        try { ///app will not crash
            imgUri=data.getData();
            if (!imgUri.equals(""))
                startActivity(new Intent( MainActivity.this,Final.class)
                );
        } catch (Exception e) {

        }

    };
}
