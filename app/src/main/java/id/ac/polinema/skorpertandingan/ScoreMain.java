package id.ac.polinema.skorpertandingan;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ScoreMain extends AppCompatActivity {
    public final Fragment argumentFragment = new BlankFragment();//Get Fragment Instance
    public final FragmentManager manager = getSupportFragmentManager();
    public final FragmentTransaction transaction = manager.beginTransaction();

//    private int mNo;
//    private Fragment fg = new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_main);

        //final BlankFragment frag = new BlankFragment();

        String iniTeamH = getIntent().getStringExtra("timHome");
        String iniTeamA = getIntent().getStringExtra("timAway");
        int sH = getIntent().getIntExtra("skor", 0);


        Bundle data = new Bundle();//Use bundle to pass data
        data.putString("dataH", iniTeamH);//put string, int, etc in bundle with a key value
        data.putString("dataA", iniTeamA);//put string, int, etc in bundle with a key value
        data.putInt("skorH", sH);

        //banyak sisa experiment yg bisa buat belajar
//        TextView tvNamaH = findViewById(R.id.rvNamaHome);
//        tvNamaH.setText(getIntent().getStringExtra("timHome"));
//        TextView tvNamaA = findViewById(R.id.rvNamaAway);
//        tvNamaA.setText(getIntent().getStringExtra("timAway"));

        Bundle extras = getIntent().getExtras();

//        Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("BitmapAway");
//        ImageView ivA = findViewById(R.id.ivInAway);
//        ivA.setImageBitmap(bitmap);

//        if(getIntent().hasExtra("BitmapAway")) {
//            ImageView ivA = findViewById(R.id.ivInAway);
//            Bitmap b = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("BitmapAway"),0,getIntent().getByteArrayExtra("BitmapAway").length);
//            ivA.setImageBitmap(b);
//        }
//        if(getIntent().hasExtra("BitmapHome")) {
//            ImageView ivH = findViewById(R.id.ivInHome);
//            Bitmap a = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("BitmapAway"),0,getIntent().getByteArrayExtra("BitmapAway").length);
//            ivH.setImageBitmap(a);
//        }

        Bitmap bitmapH = extras.getParcelable("BitmapAway");
        Bitmap bitmapA = extras.getParcelable("BitmapHome");

        data.putParcelable("gambarHome", bitmapH);
        data.putParcelable("gambarAway", bitmapA);
        argumentFragment.setArguments(data);//Finally set argument bundle to fragment
//        ImageView ivH = findViewById(R.id.ivInHome);
//        ImageView ivA = findViewById(R.id.ivInAway);
//        ivH.setImageBitmap(bitmapH);
//        ivA.setImageBitmap(bitmapA);

        if (savedInstanceState == null) {
            transaction.add(R.id.container, argumentFragment, "Default");
            transaction.commitNow();
        }

        findViewById(R.id.addHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vH) {
                loadFragment(new addHome());
            }
        });
        findViewById(R.id.addAway).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vA) {
                loadFragment(new addAway());
            }
        });
        findViewById(R.id.btToReview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vA) {
                loadFragment(argumentFragment);
            }
        });

        Button btG = findViewById(R.id.btToHasil);
        btG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreMain.this, HasilActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void loadFragment(Fragment fr) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.container, fr);
        fragmentTransaction.commit();
    }

//    private void changePage(int mNo) {
//        //changeNumber(mNo);
//        changeFragment(mNo);
//    }
//
//    private void initSelector() {
//        findViewById(R.id.addAway).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mNo>1){
//                    changePage(--mNo);
//                }
//            }
//        });
//        findViewById(R.id.addHome).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mNo<2){
//                    changePage(++mNo);
//                }
//            }
//        });
//    }

//    private void changeFragment(int mNo) {
//        FragmentManager fm = getSupportFragmentManager();
//        Class<BlankFragment> fragment= null;
//        switch (mNo)
//        {
//            case 1 : fm.beginTransaction().replace(R.id.container, BlankFragment).commitNow(); break;
//        }
//    }
}
