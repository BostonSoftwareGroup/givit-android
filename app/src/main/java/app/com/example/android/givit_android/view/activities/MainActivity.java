package app.com.example.android.givit_android.view.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import app.com.example.android.givit_android.R;
import app.com.example.android.givit_android.view.fragments.BrowsingFragment;
import app.com.example.android.givit_android.view.fragments.LoginFragment;
import app.com.example.android.givit_android.view.fragments.ResetPasswordFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(R.id.home_fragment, new BrowsingFragment(), true);
    }

    private void setActionbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void replaceFragment(int layout, Fragment newFragment, boolean isFirstFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
        if (isFirstFragment) {
            fragmentTransaction.add(layout, newFragment);
        } else {
            fragmentTransaction.replace(layout, newFragment);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

}
