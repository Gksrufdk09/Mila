import java.util.Scanner;

public class bj14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2]; // N+1일까지 사용하기 위해 N+2 크기로 설정

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        // 역순으로 DP 테이블 채우기
        for (int i = N; i > 0; i--) {
            int nextDay = i + T[i];
            if (nextDay <= N + 1) {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[nextDay]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
        sc.close();
    }
}
