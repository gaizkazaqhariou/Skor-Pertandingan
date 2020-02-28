package id.ac.polinema.skorpertandingan;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ScoreMain extends AppCompatActivity {

//    private int mNo;
//    private Fragment fg = new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_main);

        final BlankFragment frag = new BlankFragment();
        FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();

        Bundle extras = getIntent().getExtras();
//sadbhsagdashgsa
        Bitmap bitmapH = extras.getParcelable("BitmapAway");
        ImageView ivH = findViewById(R.id.ivInHome);
        ivH.setImageBitmap(bitmapH);

        if (savedInstanceState == null) {
            transaction.add(R.id.container, frag, "Default");
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

        Button btG = findViewById(R.id.btToHasil);
        btG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreMain.this, HasilActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadFragment(Fragment fr) {
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
