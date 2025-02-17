import java.io.*;
import java.util.*;

public class bj1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 정점 개수
        int m = Integer.parseInt(st.nextToken());  // 간선 개수
        int start = Integer.parseInt(st.nextToken());  // 시작 정점

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);  // 방문 순서 오름차순 정렬
        }

        boolean[] visited = new boolean[n + 1];
        dfs(graph, visited, start);
        System.out.println();

        Arrays.fill(visited, false);  // 방문 배열 초기화
        bfs(graph, visited, start);
    }

    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(graph, visited, next);
            }
        }
    }

    public static void bfs(ArrayList<Integer>[] graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
