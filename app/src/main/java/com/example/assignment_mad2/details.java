package com.example.assignment_mad2;

public class details {
private String name;
private String age;
private String gender;
private String hobbies;
private String dob;
private String id;
private String pass;
public details(){
}

    public details(String id, String name, String age, String gender, String hobbies, String dob) {
        this.id = id;
        this.name= name;
        this.age = age;
        this.gender = gender;
        this.hobbies=hobbies;
        this.dob=dob;
      //  this.pass=pass;
    }

    public details(String name, String age, String gender, String hobbies, String dob) {
        this.name= name;
        this.age = age;
        this.gender = gender;
        this.hobbies=hobbies;
        this.dob=dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby(){
    return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getDob(){
    return dob;
    }

    public void setDob(String dob){
    this.dob=dob;
    }

    public String getPass(){
    return pass;
    }
}
