public class Assign12 {
    public static void main(String[] args) {
        // int result = sumN(5);
        // System.out.print(result);
        int result = factorial(3);
        System.out.print(result);

    }

    public static int sumN(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sumN(num - 1);
    }

    public static int sumNEven(int num) {
        if (num == 1) {
            return 2;
        }
        return num * 2 + sumNEven(num - 1);
    }

    public static int sumNOdd(int num) {
        if (num == 1) {
            return 3;
        }
        return num * 3 + sumNOdd(num - 1);
    }

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static int sumDigit(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 10 * sumDigit(num / 10);
    }

}