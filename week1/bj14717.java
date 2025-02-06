import java.util.*;

public class bj14717 {
    // 족보 계산 함수
    public static int getScore(int x, int y) {
        if (x == y) return 100 + x; // 땡 (100 + 숫자, 예: 10땡 -> 110)
        return (x + y) % 10; // 끗 (두 숫자의 합을 10으로 나눈 나머지)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        sc.close();

        // 영학이의 패 점수 계산
        int myScore = getScore(A, B);

        int winCount = 0, totalCases = 0;

        // 남은 카드 생성 (1~10이 각 2장씩 있음 → (A, B) 제외)
        int[] cards = new int[20];
        int idx = 0;
        for (int num = 1; num <= 10; num++) {
            for (int count = 0; count < 2; count++) {
                if ((num == A && count == 0) || (num == B && count == 1)) continue; // 영학이 패 제외
                cards[idx++] = num;
            }
        }

        // 모든 가능한 상대 패 확인 (18장 중 2장 선택)
        for (int i = 0; i < 17; i++) {
            for (int j = i + 1; j < 18; j++) {
                totalCases++; // 가능한 상대방 패 개수 증가
                int opponentScore = getScore(cards[i], cards[j]);
                if (myScore > opponentScore) winCount++; // 영학이가 이긴 경우
            }
        }

        // 확률 계산 및 출력 (소수점 셋째 자리까지 반올림)
        double winRate = (double) winCount / totalCases;
        System.out.printf("%.3f\n", winRate);
    }
}
