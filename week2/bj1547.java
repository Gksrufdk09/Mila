import java.util.Scanner;

public class bj1547 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();  // 컵 위치를 바꾸는 횟수
        int currentPosition = 1;  // 초기 공의 위치는 1번 컵

        for (int i = 0; i < M; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            
            if (X == currentPosition) {
                currentPosition = Y;
            } else if (Y == currentPosition) {
                currentPosition = X;
            }
        }
        
        System.out.println(currentPosition);
    }
}
