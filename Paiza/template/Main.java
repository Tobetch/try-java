package template;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void tmpMethod1() {
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
