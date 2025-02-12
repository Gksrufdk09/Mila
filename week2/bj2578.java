import java.util.*;

public class bj2578 {
    static int[][] board = new int[5][5];
    static boolean[][] marked = new boolean[5][5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 사회자가 부르는 숫자 입력 및 처리
        int result = 0;
        for (int k = 0; k < 25; k++) {
            int num = sc.nextInt();
            markNumber(num);  // 숫자를 체크
            if (checkBingo() >= 3) {  // 빙고 개수 확인
                result = k + 1;
                break;
            }
        }

        // 결과 출력
        System.out.println(result);
        sc.close();
    }

    // 숫자 체크
    static void markNumber(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    marked[i][j] = true;
                    return;
                }
            }
        }
    }

    // 빙고 개수 확인
    static int checkBingo() {
        int bingoCount = 0;

        // 가로와 세로 빙고 확인
        for (int i = 0; i < 5; i++) {
            if (isBingoRow(i)) bingoCount++;
            if (isBingoCol(i)) bingoCount++;
        }

        // 대각선 빙고 확인
        if (isBingoDiagonal1()) bingoCount++;
        if (isBingoDiagonal2()) bingoCount++;

        return bingoCount;
    }

    // 가로 빙고 확인
    static boolean isBingoRow(int row) {
        for (int j = 0; j < 5; j++) {
            if (!marked[row][j]) return false;
        }
        return true;
    }

    // 세로 빙고 확인
    static boolean isBingoCol(int col) {
        for (int i = 0; i < 5; i++) {
            if (!marked[i][col]) return false;
        }
        return true;
    }

    // 대각선1 (↘ 방향) 빙고 확인
    static boolean isBingoDiagonal1() {
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) return false;
        }
        return true;
    }

    // 대각선2 (↙ 방향) 빙고 확인
    static boolean isBingoDiagonal2() {
        for (int i = 0; i < 5; i++) {
            if (!marked[i][4 - i]) return false;
        }
        return true;
    }
}
