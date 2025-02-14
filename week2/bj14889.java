import java.util.Scanner;

public class bj14889 {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N][N];
        visited = new boolean[N];

        // 능력치 배열 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        // 백트래킹을 통한 팀 구성
        divideTeams(0, 0);
        System.out.println(minDifference);
    }

    // 팀을 나누는 백트래킹 메서드
    static void divideTeams(int idx, int count) {
        if (count == N / 2) {
            calculateDifference();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                divideTeams(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    // 두 팀의 능력치 차이를 계산하는 메서드
    static void calculateDifference() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += S[i][j] + S[j][i];
                }
            }
        }

        int difference = Math.abs(startTeam - linkTeam);
        if (difference == 0) {
            System.out.println(difference);
            System.exit(0);
        }
        minDifference = Math.min(minDifference, difference);
    }
}
