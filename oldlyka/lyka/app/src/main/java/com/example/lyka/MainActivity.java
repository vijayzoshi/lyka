package com.example.lyka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       /*try {
            URL serverUrl = new URL("https://meet.jit.si");
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(serverUrl.getHost())
                    .setRoom("test123")
                    .setAudioMuted(false)
                    .setVideoMuted(false)
                    .setAudioOnly(false)
                    .setWelcomePageEnabled(false)
                    .setConfigOverride("requireDisplayName", true)
                    .build();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
*/



        NavigationBarView bottomnav = findViewById(R.id.bottom_navigation_view);
        bottomnav.setOnItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();


        
    }


    private NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {


            Fragment selectedfragment = null;
            switch (menuItem.getItemId()) {

                case R.id.home:
                    selectedfragment = new Home();
                    break;

                case R.id.circles:
                    selectedfragment = new Circles();
                    break;

                case R.id.community:
                    selectedfragment = new Community();
                    break;


            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedfragment).commit();


            return true;
        }
    };

}