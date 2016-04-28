package br.com.buylist.views;

import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.com.buylist.R;
import br.com.buylist.fragments.HomeFragment;

public class Home extends ActionBarActivity {

    private Toolbar toolbar;
    private String TITLES[] = { "Home", "My lists", "My list items", "Logout" };
    private int ICONS[] = {
        R.drawable.ic_home_white,
        R.drawable.ic_view_list_white,
        R.drawable.ic_dns_white,
        R.drawable.ic_exit_to_app_white
    };

    RecyclerView recycleView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        recycleView = (RecyclerView) findViewById(R.id.RecyclerView);
        recycleView.setHasFixedSize(true);

        drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);

        // Instancia o navigation drawer
        adapter = new NvDrawerHeader(TITLES,ICONS, this.toolbar.getContext(), this.getSupportFragmentManager(), drawer);
        recycleView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);

        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerOpened(View drawerView) {

                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {

                super.onDrawerClosed(drawerView);
            }
        };

        drawer.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        this.getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.content_frame, new HomeFragment())
            .commit();
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings)
            return true;

        return  super.onOptionsItemSelected(item);
    }
}
