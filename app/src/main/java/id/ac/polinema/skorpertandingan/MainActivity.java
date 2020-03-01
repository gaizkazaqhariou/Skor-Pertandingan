package id.ac.polinema.skorpertandingan;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

//coba pake interface buat kirim data
public class MainActivity extends AppCompatActivity /*implements addHome.sendSkor*/ {
    static final int REQUEST_IMAGE_GET1 = 1;
    static final int REQUEST_IMAGE_GET2 = 2;
    ImageView ivFotoA;
    ImageView ivFotoH;
    Uri uriFoto1;
    Uri uriFoto2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText teamHome = findViewById(R.id.etNamaHome);
        final EditText teamAway = findViewById(R.id.etNamaAway);
        ivFotoA = findViewById(R.id.ivInAway);
        ivFotoH = findViewById(R.id.ivInHome);

        ivFotoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vA) {
                pickPhotoA(vA);
            }
        });
        ivFotoH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vH) {
                pickPhotoH(vH);
            }
        });

        Button btN = findViewById(R.id.btNext);
        btN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScoreMain.class);
                intent.putExtra("timHome", teamHome.getText().toString());
                intent.putExtra("timAway", teamAway.getText().toString());

                //banyak sisa experiment yg bisa buat belajar
                ivFotoA.buildDrawingCache();
                ivFotoH.buildDrawingCache();
                Bitmap bitmap1 = ivFotoA.getDrawingCache();
                Bitmap bitmap2 = ivFotoH.getDrawingCache();

                intent.putExtra("BitmapAway", bitmap1);
                intent.putExtra("BitmapHome", bitmap2);

                //===================

//                ByteArrayOutputStream _bs = new ByteArrayOutputStream();
//                bitmap1.compress(Bitmap.CompressFormat.PNG, 50, _bs);
//                intent.putExtra("BitmapAway", _bs.toByteArray());
//                bitmap2.compress(Bitmap.CompressFormat.PNG, 50, _bs);
//                intent.putExtra("BitmapHome", _bs.toByteArray());

                //===================

                startActivity(intent);
            }
        });
    }

    private void pickPhotoA(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE_GET1);
    }

    private void pickPhotoH(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE_GET2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_GET1) {
            uriFoto1 = data.getData();
            ivFotoA.setImageURI(uriFoto1);
        }
        if (requestCode == REQUEST_IMAGE_GET2) {
            uriFoto2 = data.getData();
            ivFotoH.setImageURI(uriFoto2);
        }
    }
}
