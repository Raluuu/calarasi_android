package com.miguelcr.a01_simplelist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import io.realm.Realm;

public class NewStudentActivity extends AppCompatActivity {
    EditText editTextName, editTextAge;
    RadioGroup radioGroupSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        radioGroupSex = (RadioGroup) findViewById(R.id.radioGroupSex);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveStudent();
            }
        });
    }

    private void saveStudent() {
        String name = editTextName.getText().toString();
        String age = editTextAge.getText().toString();

        int idRadioButtonSelected = radioGroupSex.getCheckedRadioButtonId();
        String sex = "f";
        if(idRadioButtonSelected==R.id.radioButtonMale) {
            sex = "m";
        }

        // Create an student object
        Student newStudent = new Student();
        newStudent.setName(name);
        newStudent.setAge(Integer.parseInt(age));
        newStudent.setSex(sex);

        // Save in the database
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(newStudent);
        realm.commitTransaction();

        finish();
    }

}
