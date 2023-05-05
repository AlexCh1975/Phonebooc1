package db;

import data.User;
import utils.WriterFilesService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    static Connection dbconnect;
    public static Connection getDbconnect() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/db_phonebook?useSSl=false";
        String username = "root";
        String password = "**********";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection dbconnect = DriverManager.getConnection(url, username, password);
        System.out.println("Успешное соединение!");

        return dbconnect;
    }

    public static void addUser(User user) {
        String lastname = user.getLastname();
        String name = user.getName();
        String surname = user.getSurname();
        String birthday = user.getBirthday();
        long phone = user.getPhone();
        String gender = user.getGender();

        try {
            String insert = "INSERT INTO users (lastname, name, surname, birthday, phone, gender) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement prSt = getDbconnect().prepareStatement(insert);
            prSt.setString(1, lastname);
            prSt.setString(2, name);
            prSt.setString(3, surname);
            prSt.setString(4, birthday);
            prSt.setLong(5, phone);
            prSt.setString(6, gender);

            prSt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Нет соединения с базой данных!");
            System.out.println(ex.getMessage());
        }
    }

    public static List<User> find(String lastname) {
        List<User> users = new ArrayList<>();
        try {
            String select = "SELECT lastname, name, surname, " +
                    "birthday, phone, gender FROM users WHERE lastname = ?";
            PreparedStatement prSt = getDbconnect().prepareStatement(select);
            prSt.setString(1, lastname);
            ResultSet results = prSt.executeQuery();

            while (results.next()) {
                User user = new User(
                        results.getString(1),
                        results.getString(2),
                        results.getString(3),
                        results.getString(4),
                        results.getLong(5),
                        results.getString(6));

                users.add(user);
            }

        } catch (Exception ex) {
            System.out.println("Нет соединения с базой данных!");
            System.out.println(ex.getMessage());
        }
        if (users.isEmpty()) return null;
        return users;
    }

    public static void getDBphonebook() {
        List<String> users = new ArrayList<>();
        try {
            String select = "SELECT lastname, name, surname, " +
                    "birthday, phone, gender FROM users";
            PreparedStatement prSt = getDbconnect().prepareStatement(select);
            ResultSet results = prSt.executeQuery();
            while (results.next()) {
                String lastname = results.getString(1);
                String name = results.getString(2);
                String surname = results.getString(3);
                String birthday = results.getString(4);
                String phone = String.valueOf(results.getLong(5));
                String gender = results.getString(6);

                users.add(String.format(lastname + " |\t" +
                        name + " |\t" + surname + " |\t" + birthday + " |\t" +
                        phone + " |\t" + gender));

            }
            WriterFilesService.write(users);
        } catch (Exception ex) {
            System.out.println("Нет соединения с базой данных!");
            System.out.println(ex.getMessage());
        }

    }
}
