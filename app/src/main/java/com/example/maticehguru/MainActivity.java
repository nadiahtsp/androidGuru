package com.example.maticehguru;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.maticehguru.Fragments.GuruFragmentHome;
import com.example.maticehguru.Fragments.GuruHistoryFragment;
import com.example.maticehguru.Fragments.GuruListPesananFragment;
import com.example.maticehguru.Fragments.GuruNotifikasiFragment;
import com.example.maticehguru.Fragments.GuruScanFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView user_bottom_nav = findViewById(R.id.user_bottomnavigation);
        user_bottom_nav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.guru_fragment_container,
                new GuruFragmentHome()).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.guru_bottomnav_home:
                            selectedFragment = new GuruFragmentHome();
                            break;
                        case R.id.guru_bottomnav_scan:
                            selectedFragment = new GuruScanFragment();
                            break;
                        case R.id.guru_bottomnav_history:
                            selectedFragment = new GuruHistoryFragment();
                            break;
                        case R.id.guru_bottomnav_listPesanan:
                            selectedFragment = new GuruListPesananFragment();
                            break;
                        case R.id.guru_bottomnav_notification:
                            selectedFragment = new GuruNotifikasiFragment();
                            break;



                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.guru_fragment_container,
                            selectedFragment).commit();
                    return true;

                }
            };
}
