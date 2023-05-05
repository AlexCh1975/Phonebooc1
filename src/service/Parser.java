package service;

import data.User;

public class Parser {
    private String strUser;

    public Parser(String strUser) {
        this.strUser = strUser;
    }

    public static User parsUser(String sUser){
        String[] strUser = sUser.split(" ");
        try{
            long phone = Long.parseLong(strUser[4]);
            User user = new User(strUser[0], strUser[1], strUser[2], strUser[3],
                    phone, strUser[5]);
            return user;
        }catch(NumberFormatException e){
            System.out.println("Номер телефона некорректный!");
        }
        return null;
    }

}
