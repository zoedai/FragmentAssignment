package com.example.dai.fragmentassignment;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
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

    Communicator mCallback;

    public interface Communicator {
        void sendMessage(String msg);
    }
    public FirstFragment() {
        // Required empty public constructor
    }
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        try {
            mCallback = (Communicator) getActivity();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        View v = inflater.inflate(R.layout.fragment_first, container, false);
        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.sendMessage("Hello from fragment 1");

            }
        });
        return v;
    }


}
