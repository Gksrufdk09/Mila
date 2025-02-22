import java.io.*;
import java.util.*;

public class bj12851 {
    static int N, K;
    static int[] visited = new int[100001]; // 방문 시간 저장
    static int[] count = new int[100001]; // 방법 개수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        bfs();
        System.out.println(visited[K] - 1);
        System.out.println(count[K]);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1; // 시작점 방문 (0이 아닌 1로 설정)
        count[N] = 1; // 시작점에서 도달하는 경우의 수

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next > 100000) continue;

                if (visited[next] == 0) { // 처음 방문하는 경우
                    visited[next] = visited[cur] + 1;
                    count[next] = count[cur]; // 이전 위치에서 온 방법 개수 그대로 저장
                    queue.add(next);
                } else if (visited[next] == visited[cur] + 1) { 
                    count[next] += count[cur]; // 같은 최단 거리일 경우 방법 개수 추가
                }
            }
        }
    }
}
