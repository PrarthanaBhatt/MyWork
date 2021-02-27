package com.prarthana.myworkapplication.components.contentprovider_one;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ChooseImageActivity extends AppCompatActivity {

    Button call;
    Button uploadBtnLand,saveBtn;
    ImageView imageView;

    int SELECT_PHOTO = 1;
    Bitmap bitmap;
    Uri uri;
    String encodeImageString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_image);
        call = findViewById(R.id.call);
        uploadBtnLand = (Button) findViewById(R.id.uploadBtnLand);

        imageView = (ImageView) findViewById(R.id.imageView);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:02535522142"));
                startActivity(intent);
            }
        });

        uploadBtnLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,SELECT_PHOTO);
                Toast.makeText(ChooseImageActivity.this, "Please upload img from here..", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_PHOTO && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(ChooseImageActivity.this.getContentResolver(), uri);
                imageView.setImageBitmap(bitmap);
                imageConversion();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void imageConversion() {
        //encode image to base64 string
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 75, baos);
        byte[] imageBytes = baos.toByteArray();
        encodeImageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        Toast.makeText(getApplicationContext(), "Encoded String is:"+encodeImageString, Toast.LENGTH_SHORT).show();
    }
}