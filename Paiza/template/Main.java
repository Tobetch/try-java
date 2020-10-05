package template;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            Main m = new Main();

            Integer[] input1 = m.inputNum(sc, 2, 1).getTmpList();
            int maxInputColumn = input1[0];
            System.out.println("maxInputColumn : " + maxInputColumn);
            int maxInputRow = input1[1];
            System.out.println("maxInputRow : " + maxInputRow);

            List<Integer[]> input2 = new ArrayList<>();
            for (int i = 0; i < maxInputRow; i++) {
                input2.add(i, m.inputNum(sc, maxInputColumn, maxInputRow).getTmpList());
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("エラー：" + e.getMessage());
        }

    }

    private List<Integer[]> inputNum(Scanner sc, int maxInputColumn, int maxInputRow) {
        String delimiter = " ";
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < maxInpuRow; i++) {
            String line = "";
            boolean hasInputError = true;

            while (hasInputError) {
                line = sc.nextLine();
                hasInputError = false;
                if (line.isEmpty() || line.split(delimiter).length != maxInputColumn) {
                    System.out.println("エラー：いずれかの値が入力されていません。");
                    hasInputError = true;
                    continue;
                }

                TemplateInput tempInput = new TemplateInput(line.split(delimiter));
                for (int j = 0; j < maxInputColumn; j++) {
                    if (!tempInput.isValid(j)) {
                        System.out.printf("エラー：入力条件を満たしていません。(%d番目の引数)\n", j + 1);
                        hasInputError = true;
                        break;
                    }
                }
            }

            list.set(i, new TemplateInput(line.split(delimiter)).getTmpList());

        }

        return list;

    }
    // private void tmpMethod() {
    // }

    class TemplateInput {
        private Integer[] tmpList;

        public TemplateInput(String[] strArray) {
            Integer[] tmp = new Integer[strArray.length];
            for (int i = 0; i < strArray.length; i++) {
                tmp[i] = Integer.parseInt(strArray[i]);
            }
            this.tmpList = tmp;
        }

        public Integer[] getTmpList() {
            return tmpList;
        }

        public void setTmpList(Integer[] tmpList) {
            this.tmpList = tmpList;
        }

        public boolean isValid(Integer id) {
            switch (id) {
                case 0:
                    return (this.tmpList[id] >= 1 && this.tmpList[id] <= 1000);
                case 1:
                    return (this.tmpList[id] >= 1 && this.tmpList[id] <= 1000);
                case 2:
                    return (this.tmpList[id] >= 1 && this.tmpList[id] <= 1000);
                case 3:
                    return (this.tmpList[id] >= 1 && this.tmpList[id] <= 1000);
                case 4:
                    return (this.tmpList[id] >= 1 && this.tmpList[id] <= 1000);
                case 5:
                    return (this.tmpList[id] >= 1 && this.tmpList[id] <= 1000);
                default:
                    return (this.tmpList[id] >= 1 && this.tmpList[id] <= 1000);
            }
        }

    }

}