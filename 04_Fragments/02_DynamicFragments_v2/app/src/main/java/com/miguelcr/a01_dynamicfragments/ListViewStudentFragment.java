package com.miguelcr.a01_dynamicfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewStudentFragment extends Fragment {


    public ListViewStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list_view_student, container, false);

        ListView listView = (ListView) v.findViewById(R.id.listViewLandscape);

        List<Student> students = new ArrayList<>();
        students.add(new Student("https://s3.amazonaws.com/uifaces/faces/twitter/rssems/128.jpg","Barbu"));
        students.add(new Student("https://s3.amazonaws.com/uifaces/faces/twitter/nzcode/128.jpg","Maria"));
        students.add(new Student("https://s3.amazonaws.com/uifaces/faces/twitter/ashleyford/128.jpg","Catalian"));
        students.add(new Student("https://s3.amazonaws.com/uifaces/faces/twitter/felipebsb/128.jpg","Gabriel"));
        students.add(new Student("https://s3.amazonaws.com/uifaces/faces/twitter/mattsince87/128.jpg","Mitza"));
        students.add(new Student("https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg","Christian"));

        MyStudentAdapter adapter = new MyStudentAdapter(
                getActivity(),
                R.layout.student_list_item,
                students
        );

        listView.setAdapter(adapter);

        return v;

    }

}
