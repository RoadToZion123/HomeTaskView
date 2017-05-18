package epam.androidlab.com.hometaskview;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import epam.androidlab.com.hometaskview.fragments.HuskyFragment;
import epam.androidlab.com.hometaskview.fragments.LabradorFragment;
import epam.androidlab.com.hometaskview.fragments.SmileyFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        ImageView drawerHeader = (ImageView) findViewById(R.id.drawer_header);
        //Uri uri = Uri.parse("http://i.imgur.com/DvpvklR.png");
        //Picasso.with(this).load(uri).into(drawerHeader);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.nav_smiley:
                fragment = new SmileyFragment();
                break;
            case R.id.nav_hasky:
                fragment = new HuskyFragment();
                break;
            case R.id.nav_labrador:
                fragment = new LabradorFragment();
                break;
        }
        if (fragment !=null) {

            FragmentManager myFragmentManager = getSupportFragmentManager();
            myFragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            item.setChecked(true);
            mDrawerLayout.closeDrawers();

        } else {
            Log.e(this.getClass().getName(), "Error. Fragment is not created");
        }
        return false;
    }

}
