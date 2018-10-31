package com.example.hp.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager viewPager;
    private FirebaseAuth firebaseAuth;
    private LinearLayout electrician;
    private LinearLayout Plumber;
    private LinearLayout Carpenter;
    private LinearLayout Health;
    private LinearLayout Appliance;
    private LinearLayout Tutor;
   // private DatabaseReference databaseReference;
    private TextView textViewEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);


        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        //textViewEmail = (TextView)findViewById(R.id.textViewEmail);

        //textViewEmail.setText("Welcome"+user.getEmail());

       // textViewEmail.setText(user.getEmail());


        /*VIEW PAGER */
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

       /* ************* BUTTTONS CODES ************* */
        /*BUTTON ELECTRICIAN*/
        electrician = findViewById(R.id.electrician);
        electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int page = 0;
                Intent intent = new Intent(NavigationDrawerActivity.this,TabbedActivity.class);
                intent.putExtra("One",page);
                startActivity(intent);
            }
        });
        /*BUTTON Plumber*/
        Plumber = findViewById(R.id.Plumber);
        Plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int page = 0;
                Intent intent = new Intent(NavigationDrawerActivity.this,TabbedActivity.class);
                intent.putExtra("One",page);
                startActivity(intent);
            }
        });
        /*BUTTON Carpenter*/
        Carpenter = findViewById(R.id.Carpenter);
        Carpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int page = 0;
                Intent intent = new Intent(NavigationDrawerActivity.this,TabbedActivity.class);
                intent.putExtra("One",page);
                startActivity(intent);
            }
        });
        /*BUTTON Health*/
        Health = findViewById(R.id.Health);
        Health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int page = 1;
                Intent intent = new Intent(NavigationDrawerActivity.this,TabbedActivity.class);
                intent.putExtra("One",page);
                startActivity(intent);
            }
        });
        /*BUTTON Appliance*/
        Appliance = findViewById(R.id. Appliance);
        Appliance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int page = 2;
                Intent intent = new Intent(NavigationDrawerActivity.this,TabbedActivity.class);
                intent.putExtra("One",page);
                startActivity(intent);
            }
        });
        /*BUTTON Tutor*/
        Tutor = findViewById(R.id.Tutor);
        Tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int page = 3;
                Intent intent = new Intent(NavigationDrawerActivity.this,TabbedActivity.class);
                intent.putExtra("One",page);
                startActivity(intent);
            }
        });

        /* ************* BUTTTONS CODES END************* */






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Fragment fragment = null;

        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent intent = new Intent(this,ProfileActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(this,MyBookings.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        if (fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();

            ft.replace(R.id.screen_area, fragment);

            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
