import java.util.Scanner;

// https://paiza.jp/works/mondai/drankfast/d1_step_distance
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String yn = "";
        try {
            int d = sc.nextInt();
            int s = sc.nextInt();
            yn = (convertKmToCm(d) / s >= 10000) ? "yes" : "no";
        } catch (Exception e) {
            System.out.println("Please input valid data");
        } finally {
            sc.close();
        }
        System.out.printf("Is over 10000 steps? => %s", yn);
    }

    private static int convertKmToCm(int km) {
        return km * 1000 * 100;
    }
}