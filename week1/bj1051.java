import java.io.*;

public class bj1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] board = new int[N][M];
        
        // 숫자 정사각형 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int maxSize = 1;  // 최소 정사각형 크기는 1x1

        // 모든 위치에서 가능한 정사각형 크기 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 1; i + k < N && j + k < M; k++) {  // k는 정사각형의 한 변의 길이 - 1
                    if (board[i][j] == board[i + k][j] && 
                        board[i][j] == board[i][j + k] && 
                        board[i][j] == board[i + k][j + k]) {
                        maxSize = Math.max(maxSize, k + 1);
                    }
                }
            }
        }

        // 가장 큰 정사각형의 넓이 출력
        System.out.println(maxSize * maxSize);
    }
}
