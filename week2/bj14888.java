import java.util.Scanner;

public class bj14888 {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4]; // +, -, *, /
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        backtrack(numbers[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    public static void backtrack(int currentResult, int index) {
        if (index == N) {
            maxValue = Math.max(maxValue, currentResult);
            minValue = Math.min(minValue, currentResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0:
                        backtrack(currentResult + numbers[index], index + 1);
                        break;
                    case 1:
                        backtrack(currentResult - numbers[index], index + 1);
                        break;
                    case 2:
                        backtrack(currentResult * numbers[index], index + 1);
                        break;
                    case 3:
                        backtrack(currentResult / numbers[index], index + 1);
                        break;
                }

                operators[i]++;
            }
        }
    }
}
