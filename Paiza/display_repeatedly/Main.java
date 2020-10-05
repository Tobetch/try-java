package display_repeatedly;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            display_repeatedly("paiza", " ", sc.nextInt());

            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void display_repeatedly(String msgInput, String delimiter, int n) {

        String msgOutput = "";
        for (int i = 0; i < n; i++) {
            msgOutput += msgInput;
            if (i != n - 1)
                msgOutput += delimiter;
        }

        System.out.println(msgOutput);

    }

}