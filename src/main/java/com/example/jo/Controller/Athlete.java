package com.example.jo.Controller;

public class Athlete {
    private int id;
    private String name;
    private String sex;
    private int age;
    private int heigth;
    private String team;
    private String sport;

    public Athlete(int id, String name, String sport, String sex,int age, int height,String team) {
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.sex=sex;
        this.age=age;
        this.heigth=height;
        this.team=team;
    }

    public int getID(int id) {
        return id;
    }

    public String setName(String name) {
        return this.name=name;
    }

    public int getSex(int sex) {
        return sex;
    }

    public int getAge(int age) {
        return age;
    }

    public int getHeight(int height) {
        return height;
    }

    public String getTeam(String team) {
        return team;
    }

    public String getSport(String sport) {
        return sport;
    }
    //public Athlete createAthlete(int id, String name, String sport)
    //{
     //   Athlete a= new Athlete(id,name,sport);
     //   return a;
    //}






}
