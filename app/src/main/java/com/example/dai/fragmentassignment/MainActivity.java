package com.example.dai.fragmentassignment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.Communicator{

    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }

    @Override
    public void sendMessage(String message) {

        SecondFragment secondFragment = (SecondFragment) getFragmentManager().
                findFragmentById(R.id.fragment2);

        if (secondFragment != null) {
            secondFragment.update(message);
        } else {
            SecondFragment newFragment = new SecondFragment();
            Bundle args = new Bundle();
            args.putString("data", message);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.replace(R.id.container, newFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }
    }
}
