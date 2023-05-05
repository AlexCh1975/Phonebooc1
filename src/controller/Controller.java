package controller;

import GUI.DataInput;
import GUI.Menu;
import data.User;
import db.DatabaseHandler;
import exception.InputException;
import service.Parser;
import service.ValidationInput;
import java.util.List;

public class Controller {
    public static void run() throws RuntimeException {
        int input = Menu.menu();
        switch (input) {
            case (1):
                String sUser = DataInput.input();
                try {
                    int length = ValidationInput.validLength(sUser);
                    if (length == -1) {
                        if (ValidationInput.valid(sUser)) {
                            User user = Parser.parsUser(sUser);
                            DatabaseHandler.addUser(user);
                        } else {
                            run();
                        }
                    } else {
                        if (length < 6)
                            throw new InputException("недостаточно", length);
                        else
                            throw new InputException("слишком много", length);
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }

                break;

            case (2):
                try {
                    while (true) {
                        String lastname = DataInput.inputLastname();
                        if (ValidationInput.validInputLastname(lastname)) {
                            List<User> users = DatabaseHandler.find(lastname);
                            if (users != null) {
                                for (User user : users) {
                                    User.print(user);
                                }
                            } else {
                                throw new InputException("С такой фамилией запист нету!");
                            }
                            break;
                        } else
                            throw new InputException("Некорректный ввод фамилии!");
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    run();
                }
                break;
            case (3):
                DatabaseHandler.getDBphonebook();
                break;
            case (4):
                System.exit(0);
                break;

        }
    }
}
