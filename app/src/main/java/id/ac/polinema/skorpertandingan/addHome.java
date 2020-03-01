package id.ac.polinema.skorpertandingan;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addHome extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //sendSkor SS;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button inputH;

    public addHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment addHome.
     */
    // TODO: Rename and change types and number of parameters
    public static addHome newInstance(String param1, String param2) {
        addHome fragment = new addHome();
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
        View view = inflater.inflate(R.layout.fragment_add_home, container, false);

        final Fragment fragment = getFragmentManager().findFragmentByTag("Default");
        inputH = view.findViewById(R.id.btAddHome);
        inputH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int data = 1;
//                SS.kirimSkor(data);
                //coba pake intent, malah data yg lain jadi null
                Intent intent = new Intent(getActivity().getBaseContext(), ScoreMain.class);
                intent.putExtra("skor", 1);
                startActivityForResult(intent, 1);
                //getActivity().startActivityFromFragment(new BlankFragment(), intent, 1);
                //fragment.getArguments().putInt("skor", 1);//stack disini
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    interface sendSkor {
        void kirimSkor(int skor);
    }
}
