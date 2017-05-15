package com.miguelcr.a01_dynamicfragments;

/**
 * Created by miguelcampos on 15/5/17.
 */

public class Student {
    private String photoPath;
    private String name;

    public Student(String photoPath, String name) {
        this.photoPath = photoPath;
        this.name = name;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
