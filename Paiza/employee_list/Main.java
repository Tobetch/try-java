package employee_list;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            employee_list(sc);
            sc.close();
        } catch (Exception e) {
            System.out.println(e + ", " + e.getMessage());
        }

    }

    private static void employee_list(Scanner sc) {

        // 入力されるデータ数(n)
        int n = sc.nextInt();
        List<Map<String, String>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Map<String, String> map = new HashMap<>();

            String name = sc.next();
            map.put("名前", name);

            Integer age = sc.nextInt();
            Integer newAge = age + 1;
            map.put("年齢", Integer.toString(newAge));

            list.add(map);
        }

        for (Map<String, String> map : list) {
            System.out.println(map.get("名前") + " " + map.get("年齢"));
        }
    }

}