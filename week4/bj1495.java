import java.io.*;
import java.util.*;

public class bj1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 곡의 개수
        int S = Integer.parseInt(st.nextToken()); // 시작 볼륨
        int M = Integer.parseInt(st.nextToken()); // 최대 볼륨

        int[] volumes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true; // 시작 볼륨 설정

        for (int i = 0; i < N; i++) {
            for (int v = 0; v <= M; v++) {
                if (dp[i][v]) {
                    if (v + volumes[i] <= M) {
                        dp[i + 1][v + volumes[i]] = true;
                    }
                    if (v - volumes[i] >= 0) {
                        dp[i + 1][v - volumes[i]] = true;
                    }
                }
            }
        }

        int maxVolume = -1;
        for (int v = M; v >= 0; v--) {
            if (dp[N][v]) {
                maxVolume = v;
                break;
            }
        }

        System.out.println(maxVolume);
    }
}
