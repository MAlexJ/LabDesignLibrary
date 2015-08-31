package com.inthecheesefactory.lab.designlibrary;

import android.content.res.Configuration;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    CoordinatorLayout rootLayout;
    FloatingActionButton fabBtn;

    LinearLayout linearLayout_1;
    LinearLayout linearLayout_2;
    LinearLayout linearLayout_3;
    LinearLayout linearLayout_4;
    LinearLayout linearLayout_5;
    LinearLayout linearLayout_6;
    LinearLayout linearLayout_7;
    LinearLayout linearLayout_8;
    LinearLayout linearLayout_9;
    ImageView imageViewOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        initInstances();

        //Anim LL
        LinearLayout[] layoutsArray = new LinearLayout[9];
        linearLayout_1 = (LinearLayout) findViewById(R.id.ll_1);
        linearLayout_2 = (LinearLayout) findViewById(R.id.ll_2);
        linearLayout_3 = (LinearLayout) findViewById(R.id.ll_3);
        linearLayout_4 = (LinearLayout) findViewById(R.id.ll_4);
        linearLayout_5 = (LinearLayout) findViewById(R.id.ll_5);
        linearLayout_6 = (LinearLayout) findViewById(R.id.ll_6);
        linearLayout_7 = (LinearLayout) findViewById(R.id.ll_7);
        linearLayout_8 = (LinearLayout) findViewById(R.id.ll_8);
        linearLayout_9 = (LinearLayout) findViewById(R.id.ll_9);
        layoutsArray[0] = linearLayout_1;
        layoutsArray[1] = linearLayout_2;
        layoutsArray[2] = linearLayout_3;
        layoutsArray[3] = linearLayout_4;
        layoutsArray[4] = linearLayout_5;
        layoutsArray[5] = linearLayout_6;
        layoutsArray[6] = linearLayout_7;
        layoutsArray[7] = linearLayout_8;
        layoutsArray[8] = linearLayout_9;

        imageViewOne = (ImageView)findViewById(R.id.iv_one);

        for (int i = 0; i < 9; i++) {
            Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_item);
            if (i == 0) {
                anim.setStartOffset(10);
            } else {
                anim.setStartOffset(100 * (i + 1));
            }
            layoutsArray[i].setAnimation(anim);

        }
        Animation animIV = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_item_img);
        animIV.setStartOffset(2100);
        imageViewOne.setAnimation(animIV);

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initInstances() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.hello_world, R.string.hello_world);
        drawerLayout.setDrawerListener(drawerToggle);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rootLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);

        fabBtn = (FloatingActionButton) findViewById(R.id.fabBtn);
        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rootLayout, "Hello. I am Snackbar!", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();
            }
        });

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle("Android");
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
            return true;

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
