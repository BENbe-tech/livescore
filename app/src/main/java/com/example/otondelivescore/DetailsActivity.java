package com.example.otondelivescore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.Context;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import Adapter.DetailAdapter;

import Model.ListItem2;


import static com.example.otondelivescore.R.id.fixtures;
import static com.example.otondelivescore.R.id.nav_view;
import static com.example.otondelivescore.R.id.recyclerViewID;

public class DetailsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private TextView name;
    private TextView description;
    private Bundle extras ;
    private ImageView imageView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem2> listItems;

    private Context context;

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
//    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);
//        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new FixturesFragment());

//        if(savedInstanceState==null){
//            getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new FixturesFragment()).commit();
//            nav_view.setCheckedItem(R.id.fixtures);
//        }

//        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item){
//
//                int id = item.getItemId();
//
//                if(id == R.id.results){
//                  Toast.makeText(DetailsActivity.this,"RESULTS", Toast.LENGTH_SHORT).show();
//
//
//                }
//
//                if(id == R.id.settings){
//                 Toast.makeText(DetailsActivity.this,"SETTINGS", Toast.LENGTH_SHORT).show();
//
//
//                }
//
//
//                if(id == R.id.fixtures){
//                   Toast.makeText(DetailsActivity.this,"FIXTURES", Toast.LENGTH_SHORT).show();
//
//                }
//
//                if(id == R.id.table){
//                 Toast.makeText(DetailsActivity.this,"TABLE", Toast.LENGTH_SHORT).show();
//
//                }
//
//                if(id == R.id.L_matches){
//             Toast.makeText(DetailsActivity.this,"LIVE MATCHES", Toast.LENGTH_SHORT).show();
//
//
//                }
//
//                if(id == R.id.news){
//           Toast.makeText(DetailsActivity.this,"NEWS", Toast.LENGTH_SHORT).show();
//
//
//                }
//
//                return true;
//            }
//
//
//        });



    name = (TextView) findViewById(R.id.dNameId);
    description = (TextView) findViewById(R.id.dDescriptionID);
        imageView = (ImageView) findViewById(R.id.imageview);

        extras = getIntent().getExtras();
    if(extras != null){
        name.setText(extras.getString("name"));

//        Log.d(TAG,  extras.getString("name"));
//        Log.d(TAG,  "ben");

        if( extras.getString("name").equals("England"))
        {

            imageView.setImageResource(R.drawable.england);
        }

        if( extras.getString("name").equals("France"))
        {
            imageView.setImageResource(R.drawable.france);
        }

        if( extras.getString("name").equals("Germany"))
        {
            imageView.setImageResource(R.drawable.germany);
        }

        if( extras.getString("name").equals("Spain"))
        {
            imageView.setImageResource(R.drawable.spain);
        }

        if( extras.getString("name").equals("Italy"))
        {
            imageView.setImageResource(R.drawable.italy);
        }

        if( extras.getString("name").equals("Tanzania"))
        {
            imageView.setImageResource(R.drawable.tanzania);
        }

        description.setText(extras.getString("description"));
    }

        recyclerView = (RecyclerView) findViewById(recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        ListItem2 item1 = new ListItem2("20:00","Arsenal", "chelsea","2","1");
        ListItem2 item2 = new ListItem2("20:00","Bayern Munich","Dortmund","4","1");
        ListItem2 item3 = new ListItem2("22:00","Barcelona","Madrid","3","1");

        listItems.add(item1);
        listItems.add(item2);
        listItems.add(item3);

        adapter = new DetailAdapter(this, listItems);
        recyclerView.setAdapter(adapter);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

      switch(menuItem.getItemId()){

          case  R.id.fixtures:
              Intent fixtures = new Intent(this,FixturesActivity.class);
              startActivity(fixtures);
//              getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new FixturesFragment()).commit();
             break;

          case  R.id.table:
              Intent table = new Intent(this,TableActivity.class);
              startActivity(table);
//              getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new TableFragment()).commit();
              break;


          case  R.id.news:
              Intent news = new Intent(this,NewsActivity.class);
              startActivity(news);
//              getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new NewsFragment()).commit();
              break;

          case  R.id.settings:
              Intent settings = new Intent(this,SettingsActivity.class);
              startActivity(settings);
//              getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new SettingsFragment()).commit();
              break;

          case  R.id.L_matches:
              Intent l_matches = new Intent(this,LivematchesActivity.class);
                   startActivity(l_matches);
//              getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new LivematchesFragment()).commit();
          break;

//          case  R.id.results:
//        Intent i = new Intent(this,DetailsActivity.class);
//        startActivity(i);
//              break;
      }

      dl.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public void onBackPressed(){
        if(dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }


}