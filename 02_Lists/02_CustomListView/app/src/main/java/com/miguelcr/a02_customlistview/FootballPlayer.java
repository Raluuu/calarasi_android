package com.miguelcr.a02_customlistview;

/**
 * Created by miguelcampos on 11/5/17.
 */

class FootballPlayer {
    private String photoPath;
    private String name;
    private int age;
    private float rate;
    private int goals;

    // Code > Generate... > Constructor (select all the properties)
    public FootballPlayer(String photoPath, String name, int age, float rate, int goals) {
        this.photoPath = photoPath;
        this.name = name;
        this.age = age;
        this.rate = rate;
        this.goals = goals;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
