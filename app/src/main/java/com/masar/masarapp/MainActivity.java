package com.masar.masarapp;

//import android.app.AppComponentFactory;
//import androidx.fragment.app.Fragment;
import android.os.Bundle;
//import android.view.MenuItem;
//import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.material.bottomnavigation.BottomNavigationView;

class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

//        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
//        bottomNav.setOnNavigationItemSelectedListener(navListener);}
//
//        private BottomNavigationView.OnNavigationItemSelectedListener navListener =
//                new BottomNavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        Fragment  selectedFragment = null;
//
//                        switch (item.getItemId()) {
//                            case R.id.bottomNavigationFqa:
//                                selectedFragment = new Fqa();
//                                break;
////                            case R.id.bottomNavigationProfile:
////                                selectedFragment = new Profile();
////                                break;
////                            case R.id.bottomNavigationProfile:
////                                selectedFragment = new Profile();
////                                break;
//                            case R.id.bottomNavigationNotification:
//                                selectedFragment = new Notification();
//                                break;
////                            case R.id.bottomNavigationMore:
////                                selectedFragment = new MasarMenu();
////                                break;
//                        }
//
//
//                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_tag, selectedFragment).commit();
//                        return true;
//                    }
//                };

    }}

