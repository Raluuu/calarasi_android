package com.miguelcr.a01_dynamicfragments;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        layout = (ConstraintLayout) findViewById(R.id.layoutPortrait);

        List<Student> students = new ArrayList<>();
        students.add(new Student("https://s3.amazonaws.com/uifaces/faces/twitter/rssems/128.jpg","Barbu"));
        students.add(new Student("https://s3.amazonaws.com/uifaces/faces/twitter/nzcode/128.jpg","Maria"));
        students.add(new Student("https://s3.amazonaws.com/uifaces/faces/twitter/ashleyford/128.jpg","Catalian"));
        students.add(new Student("https://s3.amazonaws.com/uifaces/faces/twitter/felipebsb/128.jpg","Gabriel"));
        students.add(new Student("https://s3.amazonaws.com/uifaces/faces/twitter/mattsince87/128.jpg","Mitza"));
        students.add(new Student("https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg","Christian"));

        if(layout!=null) {
            // Portrait
            Toast.makeText(this, "Portrait", Toast.LENGTH_SHORT).show();

            GridView gridView = (GridView) findViewById(R.id.gridViewPortrait);

            MyStudentAdapter adapter = new MyStudentAdapter(
                    this,
                    R.layout.student_grid_item,
                    students
            );

            gridView.setAdapter(adapter);


        } else {
            // Landscape
            Toast.makeText(this, "Landscape", Toast.LENGTH_SHORT).show();

            ListView listView = (ListView) findViewById(R.id.listViewLandscape);

            MyStudentAdapter adapter = new MyStudentAdapter(
                    this,
                    R.layout.student_list_item,
                    students
            );

            listView.setAdapter(adapter);
        }


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
