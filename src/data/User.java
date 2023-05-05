package data;

import java.util.Date;

public class User {
    private String lastname;
    private String name;
    private String surname;
    private String birthday;
    private  long phone;
    private String gender;

    public User(String lastname, String name, String surname, String birthday,
                long phone, String gender) {
        this.lastname = lastname;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public long getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return " |"+ "фамилия: " +getLastname()+"|\t|"+"имя: "+getName()+"|\t|" + "отчество: "+
                getSurname()+"|\t|"+"дата рождения: "+getBirthday() +"|\t|"+"телефон: "+
                getPhone()+"|\t|"+"пол: "+getGender()+ "| ";
    }
    public static void print(User user){
        System.out.println(" |"+ "фамилия: " +user.getLastname()+"|\t|"+"имя: "+user.getName()+"|\t|" + "отчество: "+
                user.getSurname()+"|\t|"+"дата рождения: "+user.getBirthday() +"|\t|"+"телефон: "+
                user.getPhone()+"|\t|"+"пол: "+user.getGender()+ "| ");
    }
}
