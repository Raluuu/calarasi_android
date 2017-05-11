package com.miguelcr.a02_customlistview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<FootballPlayer> footballPlayerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listViewFootballPlayers);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // 2. Create a List<FootballPlayer>
        footballPlayerList = new ArrayList<>();
        footballPlayerList.add(new FootballPlayer("http://images.performgroup.com/di/library/GOAL/cf/3f/cristiano-ronaldo-real-madrid-bayern-munich-ucl-18042017_1iie1fj0jf7qk1gokux9i21ra0.jpg",
                "Ronaldo",46,1.0f,10000));
        footballPlayerList.add(new FootballPlayer("http://cde.3.depor.pe/ima/0/0/1/7/2/172647.jpg","Messi",15,0.5f,1));

        // 3. ArrayAdapter
        MyFootballPlayerAdapter adapter = new MyFootballPlayerAdapter(
                this,
                R.layout.football_player_item,
                footballPlayerList
        );

        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
