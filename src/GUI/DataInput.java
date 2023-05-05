package GUI;

import java.util.Scanner;
public class DataInput {
    public static String input(){
        System.out.print("Введите данные записи в телефонную книгу (одной строкой с пробелами):\n" +
                "Фамилию (Иванов) \n" +
                "Имя (Иван) \n" +
                "Отчество (Ивановичь) \n" +
                "Дата рождения (yyyy-mm-dd) \n" +
                "Телефон (888888888) \n" +
                "пол (f - женщина, m - мужчина) \n" +
                "> ");
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        return user;
    }



    public static String inputLastname(){
        System.out.print("Введите Фамилию для поиска: ");
        Scanner sc = new Scanner(System.in);
        String lastname = sc.nextLine();
        return lastname;
    }
}
