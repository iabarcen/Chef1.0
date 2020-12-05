package com.example.chef10;
// Test 2.0
//import android.media.Image;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.SearchView;
//import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.MenuItemCompat;

//import android.view.MenuInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.SearchView;

import java.util.ArrayList;

//Image
import android.widget.ImageView; //ME
import android.graphics.Color; //ME

//Search Bar
import android.widget.Toast;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //ImageView imageView1; //ME

    //Initialize variable
    ListView listView;
    ArrayList<String> stringArrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //imageView1 = findViewById(R.id.image_view1);
        //imageView1.setBackgroundColor(Color.rgb(225, 200, 100));


        //SEARCH BAR
        listView = findViewById(R.id.list_view);

        stringArrayList.add("Rice");
        stringArrayList.add("Ricotta Cheese");
        stringArrayList.add("Mussarela Cheese");
        stringArrayList.add("Milk");

        adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, stringArrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), adapter.getItem(position),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_bar,menu);

        MenuItem menuItem = menu.findItem(R.id.search_view);

       //SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        SearchView searchView = (SearchView) menuItem.getActionView(); //THIS is not working

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText){
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


}