import java.io.*;

public class bj1018 {
    static char[][] board;
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        board = new char[N][M];

        // 체스판 입력
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minRepaint = Integer.MAX_VALUE;

        // 모든 8x8 크기 체스판 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minRepaint = Math.min(minRepaint, getRepaintCount(i, j));
            }
        }

        System.out.println(minRepaint);
    }

    // 8x8 체스판을 색칠해야 하는 개수를 구하는 함수
    private static int getRepaintCount(int x, int y) {
        int repaintBW = 0, repaintWB = 0;

        // (x,y) 위치에서 8x8 체스판 확인
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = board[x + i][y + j];

                // 패턴 1: 시작이 'B'인 경우
                if ((i + j) % 2 == 0) {
                    if (current != 'B') repaintBW++;  // 'B'가 되어야 하는데, 아니면 repaint++
                    if (current != 'W') repaintWB++;  // 'W'가 되어야 하는데, 아니면 repaint++
                } 
                // 패턴 2: 시작이 'W'인 경우
                else {
                    if (current != 'W') repaintBW++;  // 'W'가 되어야 하는데, 아니면 repaint++
                    if (current != 'B') repaintWB++;  // 'B'가 되어야 하는데, 아니면 repaint++
                }
            }
        }

        return Math.min(repaintBW, repaintWB);
    }
}
