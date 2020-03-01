package id.ac.polinema.skorpertandingan;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.review_layout, container, false);

        TextView tvH = view.findViewById(R.id.rvNamaHome);
        TextView tvA = view.findViewById(R.id.rvNamaAway);
        ImageView ivH = view.findViewById(R.id.rvInHome);
        Bitmap bitH = getArguments().getParcelable("gambarHome");
        ivH.setImageBitmap(bitH);
        ImageView ivA = view.findViewById(R.id.rvInAway);
        Bitmap bitA = getArguments().getParcelable("gambarAway");
        ivA.setImageBitmap(bitA);

        TextView skH = view.findViewById(R.id.rvSkorHome);
        int sH = getArguments().getInt("skorH");
        skH.setText(" " + sH);

        String teamH = getArguments().getString("dataH");
        tvH.setText("Team Home : " + teamH);
        String teamA = getArguments().getString("dataA");
        tvA.setText("Team Away : " + teamA);

        //banyak sisa experiment yg bisa buat belajar
        // Inflate the layout for this fragment
        //View view = inflater.inflate(R.layout.review_layout, container,false);
        return view;
    }

}
