package com.miguelcr.a01_simplelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    List<String> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. get the ListView reference
        listView = (ListView) findViewById(R.id.listViewStudents);

        // 2. define the list of elements we want to show in the list
        students = new ArrayList<>();
        students.add("Barbu");
        students.add("Maria");
        students.add("Catalian");
        students.add("Gabriel");
        students.add("Mitza");
        students.add("Christian");
        students.add("Mariana");
        students.add("Racula");
        students.add("Amalia");
        students.add("Dana");
        students.add("Liviu");
        students.add("Mihai");
        students.add("Mihnea");
        students.add("Posea");
        students.add("Razvan");
        students.add("Daniel");

        // 3. Declare the Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                students
        );

        //4. Connect the Adapter and ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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


    }
}
