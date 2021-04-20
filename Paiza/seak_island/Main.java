package seak_island;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }

    }

    private static FirstInput input1(Scanner sc) {
        String line;
        while (true) {
            // System.out.println("座席数とグループ数を入力してください。");
            line = sc.nextLine();
            if (line.isEmpty()) {
                System.out.println("エラー：値が入力されていません。");
                continue;
            }
            String[] input = line.split(" ");
            if (input.length != 2) {
                System.out.println("エラー：いずれかの値が入力されていません。");
                continue;
            }

            SeatsAndGroups sag = new SeatsAndGroups(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            if (!sag.isValidSeats()) {
                System.out.printf("エラー：入力条件を満たしていません。(座席数)\n");
                continue;
            } else if (!sag.isValidGroups()) {
                System.out.printf("エラー：入力条件を満たしていません。(グループ数)\n");
                continue;
            }

            return sag;
        }
    }
}

class Template {
    private Integer tmp1;
    private String tmp2;

    public Integer getTmp1() {
        return tmp1;
    }

    public void setTmp1(Integer tmp1) {
        this.tmp1 = tmp1;
    }

    public String getTmp2() {
        return tmp2;
    }

    public void setTmp2(String tmp2) {
        this.tmp2 = tmp2;
    }
}
