package com.example.maticehguru;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

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

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.guru_fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}
