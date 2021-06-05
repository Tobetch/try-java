import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int HP = sc.nextInt();
        List<Integer> paizaAttackDamages = new ArrayList<>();
        List<Integer> enemyAttackDamages = new ArrayList<>();
        int count = 0;

        while (HP > 0) {

            if (count < 2) {
                paizaAttackDamages.add(1);
                enemyAttackDamages.add(1);
                HP -= enemyAttackDamages.get(count);
            } else {
                paizaAttackDamages.add(enemyAttackDamages.get(count - 1) + enemyAttackDamages.get(count - 2));
                enemyAttackDamages.add(paizaAttackDamages.get(count - 1) * 2 + paizaAttackDamages.get(count - 2));
                HP -= enemyAttackDamages.get(count);
            }

            count++;

        }
        System.out.println(count);
        sc.close();
    }
}