package com.example.rumi.realstate;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class Util {

    public static void loadFragment(Context context, Fragment fragment) {
        FragmentTransaction transaction = ((FragmentActivity) (context)).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
