package com.miguelcr.a01_simplelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    List<Student> students;
    MyStudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. get the ListView reference
        listView = (ListView) findViewById(R.id.listViewStudents);

        // 2. define the list of elements we want to show in the list
        students = new ArrayList<>();

        // Take the information from the database
        // a. Get the database object connection
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        students = realm.where(Student.class).findAll();

        // 3. Declare the Adapter
        adapter = new MyStudentAdapter(
                this,
                R.layout.student_item,
                students
        );

        //4. Connect the Adapter and ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        getSupportActionBar().setTitle("Students");

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*
        String studentName = students.get(position);


        Toast.makeText(this, "Student: "+studentName, Toast.LENGTH_SHORT).show();

        TextView textViewName = (TextView) view;
        textViewName.setText(studentName + " Gracias ;)");

        //view.animate().setDuration(2000).rotationXBy(360).start();

        // open the StudentDetailActivity
        Intent intent = new Intent(this,StudentDetailActivity.class);
        intent.putExtra("name",studentName);
        intent.putExtra("age",20);
        startActivity(intent);

        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_new_student:
                Intent i = new Intent(this, NewStudentActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Refresh the list to show the new students added
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        students = new ArrayList<>();
        students.clear();
        students = realm.where(Student.class).findAll();

        // We notify to the Adapter that we have new students,
        // and it refresh the list.
        adapter.notifyDataSetChanged();
    }

}
