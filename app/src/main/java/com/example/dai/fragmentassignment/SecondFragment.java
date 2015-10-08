package com.example.dai.fragmentassignment;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    TextView tv;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_second, container, false);
        tv = (TextView) v.findViewById(R.id.textView);
        Bundle b = getArguments();
        if (b != null) {

            update(b);
        } else {
            Log.i("------------", "isnull");
        }

        return v;
    }

    public void update(Bundle bundle) {
        tv.setText(bundle.getString("data", "not received"));
    }


}
