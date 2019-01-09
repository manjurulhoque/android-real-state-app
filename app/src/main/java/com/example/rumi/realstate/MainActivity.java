package com.example.rumi.realstate;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.rumi.realstate.fragment.AboutFragment;
import com.example.rumi.realstate.fragment.FavouriteFragment;
import com.example.rumi.realstate.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Util.loadFragment(this, new HomeFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.navigation_home:
                transaction.replace(R.id.content_frame, new HomeFragment());
                transaction.commit();
                return true;
            case R.id.navigation_favourite:
                transaction.replace(R.id.content_frame, new FavouriteFragment());
                transaction.commit();
                return true;
            case R.id.navigation_about:
                transaction.replace(R.id.content_frame, new AboutFragment());
                transaction.commit();
                return true;
        }
        return false;
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
