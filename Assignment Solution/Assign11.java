public class Assign11 {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        // s1.pritFirstN(10);
        // s1.pritFirstNInReverseOrder(10);
        s1.printNOddNaturalNumbersInReverse(5);
    }
}

class Solution {
    public void pritFirstN(int num) {
        if (num > 0) {
            pritFirstN(num - 1);
            System.out.print(num + ",");
        }
    }

    public void pritFirstNInReverseOrder(int num) {

        if (num > 0) {
            System.out.print(num + ",");
            pritFirstNInReverseOrder(num - 1);
        }
    }

    public void printNEvenNaturalNumbers(int num) {
        if (num > 0) {
            printNEvenNaturalNumbers(num - 1);
            System.out.print(num * 2 + ",");
        }
    }

    public void printNEvenNaturalNumbersInReverse(int num) {
        if (num > 0) {
            System.out.print(num * 2 + ",");
            printNEvenNaturalNumbersInReverse(num - 1);

        }
    }

    public void printNOddNaturalNumbers(int num) {
        if (num > 0) {
            printNOddNaturalNumbers(num - 1);
            System.out.print(num * 2 - 1 + ",");
        }
    }

    public void printNOddNaturalNumbersInReverse(int num) {
        if (num > 0) {
            System.out.print(num * 2 - 1 + ",");
            printNOddNaturalNumbersInReverse(num - 1);

        }
    }
}
