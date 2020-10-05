package display_max_num;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            display_max_num(sc);
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void display_max_num(Scanner sc) {

        // "n"の取得
        int repeatNumber = sc.nextInt();
        // 最大の数(デフォルトを最小値にしています)
        int maxNum = 1;

        for (int i = 0; i < repeatNumber; i++) {
            int currentNum = sc.nextInt();
            if (currentNum > maxNum) {
                maxNum = currentNum;
            }
        }

        System.out.println(maxNum);
    }

}