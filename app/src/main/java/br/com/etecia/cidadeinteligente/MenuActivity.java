package br.com.etecia.cidadeinteligente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationview;
    ActionBarDrawerToggle toogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        toolbar = findViewById(R.id.idToolBar);
        drawerLayout = findViewById(R.id.idDrawerLayout);
        navigationview = findViewById(R.id.idNavigationView);

        navigationview.setNavigationItemSelectedListener(this);

        toogle = new ActionBarDrawerToggle(
                this, drawerLayout,
                toolbar,
                R.string.opennav,
                R.string.closenav);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.idContainerNav, new ImportFragment()).commit();

            navigationview.setCheckedItem(R.id.mAbout);
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}