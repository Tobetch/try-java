import java.util.Scanner;

// https://paiza.jp/works/mondai/drankfast/d1_step_distance
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int s = sc.nextInt();
        sc.close();
        String yn = (convertKmToCm(d) / s >= 10000) ? "yes" : "no";
        System.out.println(yn);
    }

    private static int convertKmToCm(int km) {
        return km * 1000 * 100;
    }
}