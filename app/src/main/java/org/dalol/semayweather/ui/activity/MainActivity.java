package org.dalol.semayweather.ui.activity;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import org.dalol.semayweather.R;
import org.dalol.semayweather.adapter.PopupAdapter;
import org.dalol.semayweather.adapter.TabsPagerAdapter;
import org.dalol.semayweather.di.components.DaggerForecastComponent;
import org.dalol.semayweather.di.components.DaggerNetworkComponent;
import org.dalol.semayweather.di.components.NetworkComponent;
import org.dalol.semayweather.di.modules.WeatherModule;
import org.dalol.semayweather.model.ListItem;
import org.dalol.semayweather.ui.fragment.HomeFragment;
import org.dalol.semayweather.ui.fragment.RecentFragment;
import org.dalol.weather.WeatherPresenter;
import org.dalol.weather.WeatherView;
import org.dalol.weather.model.WeatherModel;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements WeatherView {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tabs)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    @Bind(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.nav_view)
    NavigationView mNavigationView;

    private float mElevationToolBar = 15;

    private ActionBarDrawerToggle mDrawerToggle;
    private TabsPagerAdapter mAdapter;
    private AutoCompleteTextView autoComplete;

    @Inject WeatherPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        resolveDependency();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //presenter.getForecast("gonder");

        autoComplete = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        autoComplete.setThreshold(1);



        //Spinner mySpinner = (Spinner) findViewById(R.id.spinner);

        autoComplete.setAdapter(new PopupAdapter(this, R.layout.row, getAllList()));


//        mySpinner.setAdapter(new PopupAdapter(this, R.layout.row, getAllList()));
//        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> arg0, View arg1,
//                                       int pos, long arg3) {
//                // TODO Auto-generated method stub
//
//                ListItem selectedItem = (ListItem) arg0.getSelectedItem();
//
//                Toast.makeText(MainActivity.this, selectedItem.name, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//
//            }
//        });

        configNavigationWidth();

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //getSupportActionBar().setTitle("Title");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };


        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                Resources.Theme theme = this.getTheme();
                TypedArray typedArray = theme.obtainStyledAttributes(new int[]{android.R.attr.colorPrimary});
                mDrawerLayout.setStatusBarBackground(typedArray.getResourceId(0, 0));
            } catch (Exception e) {
                e.getMessage();
            }

            this.setElevationToolBar(mElevationToolBar);
        }


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }

                mDrawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.nav_screen1:
                        Toast.makeText(getApplicationContext(), "Share Selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_screen2:
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "About Selected", Toast.LENGTH_SHORT).show();
                            }
                        }, 250);

                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });

        mNavigationView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ViewTreeObserver viewTreeObserver = mNavigationView.getViewTreeObserver();
                if(viewTreeObserver.isAlive()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                    mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

                    DisplayMetrics metrics = getResources().getDisplayMetrics();

                    float width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 56, metrics);

                    float newWidth = metrics.widthPixels - width;

//                    Resources resources = getResources();
//                    float width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 360, resources.getDisplayMetrics());
                    DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) mNavigationView.getLayoutParams();
                    params.width = (int) (newWidth);
                    mNavigationView.setLayoutParams(params);
                }
            }
        });

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        configPager();


    }

    private void resolveDependency() {
        DaggerForecastComponent.builder()
                .weatherModule(new WeatherModule(this))
                .networkComponent(getNetworkComponent())
                .build()
                .inject(this);
    }

    public static ArrayList<ListItem> getAllList() {

        ArrayList<ListItem> allList = new ArrayList<ListItem>();

        ListItem item = new ListItem();
        item.setData("Current Location", "USA", R.mipmap.ic_launcher);
        allList.add(item);

        item = new ListItem();
        item.setData("Google", "USA", R.mipmap.ic_launcher);
        allList.add(item);

        item = new ListItem();
        item.setData("Apple", "USA", R.mipmap.ic_launcher);
        allList.add(item);

        item = new ListItem();
        item.setData("Samsung", "Korea", R.mipmap.ic_launcher);
        allList.add(item);

        item = new ListItem();
        item.setData("Sony", "Japan", R.mipmap.ic_launcher);
        allList.add(item);

        item = new ListItem();
        item.setData("HTC", "Taiwan", R.mipmap.ic_launcher);
        allList.add(item);

        for (int i = 0; i < 10000; i++) {
            item = new ListItem();
            item.setData("Google " + i, "USA " + i, R.mipmap.ic_launcher);
            allList.add(item);
        }

        return allList;
    }

    public void setElevationToolBar(float elevation) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.mElevationToolBar = elevation;
            mToolbar.setElevation(elevation);
        }
    }

    private void configNavigationWidth() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        //mNavigationView.getLayoutParams().width = (int) (metrics.widthPixels - CommonUtils.convertDpToPixel(DP, getApplicationContext()));
    }

    private void configPager() {
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(new RecentFragment(), "Now");
        mAdapter.addFragment(new HomeFragment(), "Forecast");
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();

        if (id == android.R.id.home) {
            Toast.makeText(getApplicationContext(), "Home Clicked!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.create();
    }

    @Override
    public void onWeatherProvide(WeatherModel model) {
        Toast.makeText(MainActivity.this, model.getCountry(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWeatherError(String errorMessage) {
        Toast.makeText(MainActivity.this, "Weather Error -> " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}
