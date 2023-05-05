package GUI;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args){
        System.out.print(menu());
    }
    public static int menu(){
        System.out.print("Выбирите операцию:\n" +
                   "Добавление записи в телефонную книгу (1) \n" +
                    "Найти запись по фамилии (2) \n" +
                    "Запросить все записи в файл (3) \n" +
                    "Выход (4) \n" +
                    "> ");
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) {
            System.out.println("Не корректный ввод! Выберите 1 или 2 или 3 или 4!");
            return menu();
        }else{
            int choice = sc.nextInt();
            if(choice == 1 || choice == 2 || choice == 3 || choice == 4)
                return choice;
            else{
                System.out.println("Не корректный ввод! Выберите 1 или 2 или 3 или 4!");
                return menu();
            }
        }
    }
}
