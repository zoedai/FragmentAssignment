package com.example.dai.fragmentassignment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_first, container, false);
        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set Fragmentclass Arguments
                Bundle bundle = new Bundle();
                String msg = "Hello from fragment 1";
                bundle.putString("data", msg);

//                SecondFragment sf = new SecondFragment();
                SecondFragment sf = (SecondFragment)getFragmentManager().
                        findFragmentById(R.id.fragment2);
                if (sf != null) {
                    sf.update(bundle);
                } else {
                    sf.setArguments(bundle);
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment2, sf);
                    transaction.addToBackStack(null);

                    transaction.commit();
                }



            }
        });
        return v;
    }


}
