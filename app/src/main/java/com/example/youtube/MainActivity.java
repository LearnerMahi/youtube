package com.example.youtube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavigationView navigationView ;
    Toolbar toolbar;
    Integer integer=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.draweradd);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        FrameLayout frameLayout=findViewById(R.id.frame);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationView.setVisibility(View.INVISIBLE);
                integer=1;
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.addone)
                {
                    integer++;
                    Toast.makeText(MainActivity.this, "add selected", Toast.LENGTH_SHORT).show();
                    if(integer%2==0)
                    {
                        navigationView.setVisibility(View.VISIBLE);
                    }
                    else if(integer%2!=0)
                    {
                        navigationView.setVisibility(View.INVISIBLE);
                    }

                    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                            return false;
                        }
                    });

                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.cast)
        {
            Intent intent = new Intent(MainActivity.this, input.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}