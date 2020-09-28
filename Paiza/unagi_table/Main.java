package unagi_table;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            SeatsAndGroups sag = getSeatsAndGroups(sc);
            String[] seats = new String[sag.getSeats()];

            List<GroupMembers> gmList = getGroupMembers(sc, sag);

            System.out.println(sitDown(seats, gmList));

            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static SeatsAndGroups getSeatsAndGroups(Scanner sc) {
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

    private static List<GroupMembers> getGroupMembers(Scanner sc, SeatsAndGroups sag) {

        List<GroupMembers> list = new ArrayList<>();
        int count = 0;
        boolean hasNextParam = true;
        while (hasNextParam) {

            if (count == sag.getGroups()) {
                // System.out.printf("指定したグループ数分(%d)入力完了。", sag.groups);
                hasNextParam = false;
                continue;
            }
            // System.out.println("グループ人数と着席開始座席番号入力してください。");
            String line = sc.nextLine();
            if (line.isEmpty()) {
                System.out.printf("エラー：指定したグループ数分(%d)を入力してください。", sag.getGroups());
                continue;
            }

            String[] input = line.split(" ");
            if (input.length != 2) {
                continue;
            }

            GroupMembers gm = new GroupMembers(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            if (!gm.isValidMembers(gm.getMembers())) {
                System.out.printf("エラー：入力条件を満たしていません。(グループ人数)\n");
                continue;
            } else if (!gm.isValidSeatedNumber(gm.getSeatedNumber())) {
                System.out.printf("エラー：入力条件を満たしていません。(着席開始座席番号)\n");
                continue;
            }

            list.add(gm);
            count++;
        }

        return list;
    }

    private static int sitDown(String[] seats, List<GroupMembers> gmList) {

        for (GroupMembers gm : gmList) {
            sitDownAllMembers(seats, gm);
        }

        int sum = 0;
        for (String seat : seats) {
            if (!Objects.equals(seat, null) && seat.equals("exist")) {
                sum++;
            }
        }
        return sum;

    }

    private static void sitDownAllMembers(String[] seats, GroupMembers gm) {
        Integer members = gm.getMembers();
        Integer sn = gm.getSeatedNumber();
        final Integer maxSn = seats.length;
        int count = 0;
        int target = 0;
        for (int i = 0; i < members; i++) {
            target = (sn + i) % maxSn;
            // System.out.println("seats : " + seats[target]);
            if (Objects.equals(seats[target], null) || seats[target].isEmpty()) {
                count++;
            } else {
                continue;
            }
        }

        if (count == members) {
            // System.out.println("置換します");
            for (int i = 0; i < members; i++) {
                target = (sn + i) % maxSn;
                seats[target] = "exist";
            }
        }
    }

}

class SeatsAndGroups {
    private Integer seats;
    private Integer groups;

    public SeatsAndGroups(Integer seats, Integer groups) {
        this.seats = seats;
        this.groups = groups;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getGroups() {
        return groups;
    }

    public void setGroups(Integer groups) {
        this.groups = groups;
    }

    public boolean isValidSeats() {
        return (this.seats >= 1 && this.seats <= 100);

    }

    public boolean isValidGroups() {
        return (this.groups >= 1 && this.groups <= 100);

    }

}

class GroupMembers {
    private Integer members;
    private Integer seatedNumber;

    public GroupMembers(Integer members, Integer seatedNumber) {
        this.members = members;
        this.seatedNumber = seatedNumber;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public Integer getSeatedNumber() {
        return seatedNumber;
    }

    public void setSeatedNumber(Integer seatedNumber) {
        this.seatedNumber = seatedNumber;
    }

    public boolean isValidMembers(Integer seats) {
        return (this.members >= 1 && this.members <= seats);

    }

    public boolean isValidSeatedNumber(Integer seats) {
        return (this.seatedNumber >= 1 && this.seatedNumber <= seats);

    }

}
