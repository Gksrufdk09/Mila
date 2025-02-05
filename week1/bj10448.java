import java.util.*;

public class bj10448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        // 1000 이하의 삼각수를 미리 저장하기
        List<Integer> triangleNumbers = new ArrayList<>();
        for (int i = 1; i * (i + 1) / 2 <= 1000; i++) {
            triangleNumbers.add(i * (i + 1) / 2);
        }

        // T번 반복
        for (int t = 0; t < T; t++) {
            int K = sc.nextInt(); // 입력받은 숫자
            boolean possible = false;

            // 세 개의 삼각수를 골라서 합이 K가 되는지 확인
            for (int i = 0; i < triangleNumbers.size(); i++) {
                for (int j = 0; j < triangleNumbers.size(); j++) {
                    for (int k = 0; k < triangleNumbers.size(); k++) {
                        if (triangleNumbers.get(i) + triangleNumbers.get(j) + triangleNumbers.get(k) == K) {
                            possible = true; // 가능하면 true로 변경
                        }
                    }
                }
            }

            // 결과 출력 (가능하면 1, 불가능하면 0)
            System.out.println(possible ? 1 : 0);
        }

        sc.close();
    }
}
