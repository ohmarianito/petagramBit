package com.coursera.petagrambit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import adapter.PageAdapter;
import com.coursera.petagrambit.fragment.FragmentPerfil;
import com.coursera.petagrambit.fragment.RecyclerviewFragment;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                Intent intentC = new Intent(this, Contacto.class);
                startActivity(intentC);
                break;
            case R.id.btnFav:
                Log.d("myTag", "This is my message");
                Intent intentF = new Intent(this, Favoritos.class);
                startActivity(intentF);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void irAFavs (View v){
        Intent intent = new Intent(this, Favoritos.class);
        startActivity(intent);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerviewFragment());
        fragments.add(new FragmentPerfil());
        return fragments;
    }
    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.hogar);
        tabLayout.getTabAt(1).setIcon(R.drawable.perro);
    }


}