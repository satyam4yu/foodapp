package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.myapplication.Adapters.MainAdapter;
import com.example.myapplication.Models.MainModel;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();
        list.add(new MainModel(R.drawable.images, "Cheese Burger" , "5", "Cheese Burger with chicken patty"));
        list.add(new MainModel(R.drawable.images1, "Chinese Combo" , "8", "schezwan noodles with munchurian"));
        list.add(new MainModel(R.drawable.images2, "Pizza" , "10", "margherita Pizza with olive oil on top"));
        list.add(new MainModel(R.drawable.images3, "Masala Dosa" , "5", "Authentic South Indian Dosa "));
        list.add(new MainModel(R.drawable.images4, "Garlic Noodles" , "5", "Noodles cooked with love and garlic"));
        list.add(new MainModel(R.drawable.images5, "Munchurian" , "5", "Munchurian Bolls in a chinese gravy"));

        MainAdapter adapter =new MainAdapter(list, this);
        binding.recyclerView.setAdapter(adapter);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}