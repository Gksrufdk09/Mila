import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < test_case; t++) {
            String coins = "";

            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    char coin = st.nextToken().charAt(0);
                    coins += coin;
                }
            }

            int minCnt = bfs(coins);
            sb.append(minCnt).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(String initialCoins) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();

        q.add(initialCoins);
        map.put(initialCoins, 0);

        while (!q.isEmpty()) {
            String curCoins = q.poll();
            int cnt = map.get(curCoins);
            //System.out.println(curCoins + " " + map.get(curCoins));

            // 모든 동전이 같은 면이면
            if (isCompleted(curCoins)) {
                return cnt;
            }

            // 8가지 연산 수행 -> 연산을 수행한 동전 상태가 map의 key에 없거나, map에 저장된 연산 횟수보다 적은 연산 횟수로 도달한다면 -> map 업데이트, 큐에 추가
            // 1. 1번째 행 뒤집기
            StringBuilder nextCoins = new StringBuilder(curCoins);
            for (int i = 0; i < 3; i++) {
                char coin = nextCoins.charAt(i);
                nextCoins.deleteCharAt(i);
                if (coin == 'H') {
                    nextCoins.insert(i, 'T');
                } else {
                    nextCoins.insert(i, 'H');
                }
            }

            if (!map.containsKey(nextCoins.toString()) || map.get(nextCoins.toString()) > cnt+1) {
                map.put(nextCoins.toString(), cnt+1);
                q.add(nextCoins.toString());
            }

            // 2. 2번째 열 뒤집기
            nextCoins = new StringBuilder(curCoins);
            for (int i = 3; i < 6; i++) {
                char coin = nextCoins.charAt(i);
                nextCoins.deleteCharAt(i);
                if (coin == 'H') {
                    nextCoins.insert(i, 'T');
                } else {
                    nextCoins.insert(i, 'H');
                }
            }

            if (!map.containsKey(nextCoins.toString()) || map.get(nextCoins.toString()) > cnt+1) {
                map.put(nextCoins.toString(), cnt+1);
                q.add(nextCoins.toString());
            }

            // 3. 3번째 행 뒤집기
            nextCoins = new StringBuilder(curCoins);
            for (int i = 6; i < 9; i++) {
                char coin = nextCoins.charAt(i);
                nextCoins.deleteCharAt(i);
                if (coin == 'H') {
                    nextCoins.insert(i, 'T');
                } else {
                    nextCoins.insert(i, 'H');
                }
            }

            if (!map.containsKey(nextCoins.toString()) || map.get(nextCoins.toString()) > cnt+1) {
                map.put(nextCoins.toString(), cnt+1);
                q.add(nextCoins.toString());
            }

            // 4. 1번째 열 뒤집기
            nextCoins = new StringBuilder(curCoins);
            for (int i = 0; i < 9; i += 3) {
                char coin = nextCoins.charAt(i);
                nextCoins.deleteCharAt(i);
                if (coin == 'H') {
                    nextCoins.insert(i, 'T');
                } else {
                    nextCoins.insert(i, 'H');
                }
            }

            if (!map.containsKey(nextCoins.toString()) || map.get(nextCoins.toString()) > cnt+1) {
                map.put(nextCoins.toString(), cnt+1);
                q.add(nextCoins.toString());
            }

            // 5. 2번째 열 뒤집기
            nextCoins = new StringBuilder(curCoins);
            for (int i = 1; i < 9; i += 3) {
                char coin = nextCoins.charAt(i);
                nextCoins.deleteCharAt(i);
                if (coin == 'H') {
                    nextCoins.insert(i, 'T');
                } else {
                    nextCoins.insert(i, 'H');
                }
            }

            if (!map.containsKey(nextCoins.toString()) || map.get(nextCoins.toString()) > cnt+1) {
                map.put(nextCoins.toString(), cnt+1);
                q.add(nextCoins.toString());
            }

            // 6. 3번째 열 뒤집기
            nextCoins = new StringBuilder(curCoins);
            for (int i = 2; i < 9; i += 3) {
                char coin = nextCoins.charAt(i);
                nextCoins.deleteCharAt(i);
                if (coin == 'H') {
                    nextCoins.insert(i, 'T');
                } else {
                    nextCoins.insert(i, 'H');
                }
            }

            if (!map.containsKey(nextCoins.toString()) || map.get(nextCoins.toString()) > cnt+1) {
                map.put(nextCoins.toString(), cnt+1);
                q.add(nextCoins.toString());
            }

            // 7. 우하향 대각선 뒤집기
            nextCoins = new StringBuilder(curCoins);
            for (int i = 0; i < 9; i += 4) {
                char coin = nextCoins.charAt(i);
                nextCoins.deleteCharAt(i);
                if (coin == 'H') {
                    nextCoins.insert(i, 'T');
                } else {
                    nextCoins.insert(i, 'H');
                }
            }

            if (!map.containsKey(nextCoins.toString()) || map.get(nextCoins.toString()) > cnt+1) {
                map.put(nextCoins.toString(), cnt+1);
                q.add(nextCoins.toString());
            }

            // 8. 좌하향 대각선 뒤집기
            nextCoins = new StringBuilder(curCoins);
            for (int i = 2; i <= 6; i += 2) {
                char coin = nextCoins.charAt(i);
                nextCoins.deleteCharAt(i);
                if (coin == 'H') {
                    nextCoins.insert(i, 'T');
                } else {
                    nextCoins.insert(i, 'H');
                }
            }

            if (!map.containsKey(nextCoins.toString()) || map.get(nextCoins.toString()) > cnt+1) {
                map.put(nextCoins.toString(), cnt+1);
                q.add(nextCoins.toString());
            }
        }

        return -1;
    }

    static boolean isCompleted(String str) {
        char coin = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (coin != str.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}