package service;

import exception.MessageException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ValidationInput {
    private static String TEMPLATE_STR = "[А-Яа-я]{1,15}";
    private static String TEMPLATE_CHAR = "[FfmM]{1}";
    private static String TEMPLATE_DATE = "[12][09][0-9][0-9]\\-[01][0-9]\\-[0-3][0-9]";
    private static String TEMPLATE_LONG = "[0-9]{6,12}";
    private String value;

    public ValidationInput(String value) {
        this.value = value;
    }

    public static int validLength(String value) {
        String[] userStr = value.split(" ");
        if (userStr.length == 6)
            return -1;
        else return userStr.length;
    }

    public static boolean valid(String value) {
        String[] usersStr = value.split(" ");

        String[] templates = {TEMPLATE_STR, TEMPLATE_STR, TEMPLATE_STR,
                TEMPLATE_DATE, TEMPLATE_LONG, TEMPLATE_CHAR};

        for (int i = 0; i < usersStr.length; i++) {

            if (!isMatchingRegexp(usersStr[i], templates[i])) {
                switch (i) {
                    case (0):
                        MessageException.getMessage("фамилии", usersStr[i]);
                        break;
                    case (1):
                        MessageException.getMessage("имени", usersStr[i]);
                        break;
                    case (2):
                        MessageException.getMessage("отчества", usersStr[i]);
                        break;
                    case (3):
                        MessageException.getMessage("дня рождения", usersStr[i]);
                        break;
                    case (4):
                        MessageException.getMessage("телефона", usersStr[i]);
                        break;
                    case (5):
                        MessageException.getMessage("пола", usersStr[i]);
                        break;
                }
                return false;
            }
        }
        return true;
    }


    public static boolean validInputLastname(String lastname) {
        String templateStr = TEMPLATE_STR;
        if (isMatchingRegexp(lastname, templateStr)) return true;
        else {
            return false;
        }
    }


    public static boolean isMatchingRegexp(final String text, final String template) {
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(template);
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
        }
        if (pattern == null) {
            return false;
        }
        final Matcher regexp = pattern.matcher(text);
        return regexp.matches();
    }

    public static void print(String[] user) {
        for (int i = 0; i < user.length; i++) {
            System.out.printf(user[i] + "\t");
        }
    }
}
