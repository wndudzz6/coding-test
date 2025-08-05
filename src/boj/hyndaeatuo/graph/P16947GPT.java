package boj.hyndaeatuo.graph;
import java.util.*;

public class P16947GPT {
    static int n;
    static boolean[] visited;
    static boolean[] isCycle;
    static ArrayList<Integer>[] graph;
    static boolean found;

    static void findCycle(int cur, int prev, int start) {
        if (cur == start && visited[cur]) {
            found = true;
            isCycle[cur] = true;
            return;
        }
        if (visited[cur]) return;

        visited[cur] = true;
        for (int next : graph[cur]) {
            if (next == prev) continue;
            findCycle(next, cur, start);
            if (found) {
                isCycle[cur] = true;
                if (cur == start) found = false; // 사이클 마킹 끝
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        isCycle = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            found = false;
            findCycle(i, -1, i);
        }

        // BFS로 거리 계산
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (isCycle[i]) {
                dist[i] = 0;
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
