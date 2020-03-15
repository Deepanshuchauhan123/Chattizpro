package com.keshav.chattizpro;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.main_tollbar);
//        setSupportActionBar(toolbar);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //mTabLayout = findViewById(R.id.main_tab_layout);

        mToolbar= findViewById(R.id.main_tollbar);
        mToolbar.inflateMenu(R.menu.game_menu);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.search_menu:
                        Toast.makeText(MainActivity.this,"Search Successful",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menus_logout:
                        Toast.makeText(MainActivity.this,"Logout Successful",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.acc_settings:
                        Toast.makeText(MainActivity.this,"Setting Successful",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.about_menu:
                        Toast.makeText(MainActivity.this,"About Successful",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.feedback_menu:
                        Toast.makeText(MainActivity.this,"Feedback Successful",Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });
        mViewPager= findViewById(R.id.viewpager);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
       // mTabLayout.setupWithViewPager(mViewPager);
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.side_menus, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.mail:
//                Toast.makeText(this,"mail Successful",Toast.LENGTH_LONG).show();
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null){
            Intent startIntent = new Intent(MainActivity.this,StartActivity.class);
            startActivity(startIntent);
            finish();
        }
    }



//    private void abc() {
//        Toast.makeText(MainActivity.this,"Logout",Toast.LENGTH_LONG).show();
//    }
}
