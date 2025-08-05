package boj.hyndaeatuo.graph;

import java.util.*;

public class P16947 {
    static int[] cycle;
    static int[][] graph;
    static int n;

    // BFS로 사이클 노드 마킹
    static void markCycleNodes() {
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        for (int start = 1; start <= n; start++) {
            if (visited[start]) continue;

            Queue<Integer> Q = new LinkedList<>();
            visited[start] = true;
            Q.offer(start);

            while (!Q.isEmpty()) {
                int now = Q.poll();

                for (int next = 1; next <= n; next++) {
                    if (graph[now][next] == 1) {
                        if (!visited[next]) {
                            visited[next] = true;
                            parent[next] = now;
                            Q.offer(next);
                        } else if (parent[now] != next) {
                            // 사이클 발견 → now와 next 경로를 모두 마킹
                            markCyclePath(now, next, parent);
                        }
                    }
                }
            }
        }
    }

    // now부터 next까지 parent 배열로 역추적하여 사이클 노드 마킹
    static void markCyclePath(int now, int next, int[] parent) {
        Set<Integer> cycleSet = new HashSet<>();
        int cur = now;
        while (cur != -1) {
            cycleSet.add(cur);
            if (cur == next) break;
            cur = parent[cur];
        }
        cur = next;
        while (cur != -1) {
            cycleSet.add(cur);
            if (cur == now) break;
            cur = parent[cur];
        }
        for (int node : cycleSet) {
            cycle[node] = 1;
        }
    }

    // BFS로 가장 가까운 사이클까지 거리 계산
    static int distance(int start) {
        if (cycle[start] == 1) return 0;

        Queue<int[]> Q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        Q.offer(new int[]{start, 0});

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            int now = cur[0];
            int dist = cur[1];

            if (cycle[now] == 1) return dist;

            for (int next = 1; next <= n; next++) {
                if (graph[now][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    Q.offer(new int[]{next, dist + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n + 1][n + 1];
        cycle = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // 사이클 노드 마킹
        markCycleNodes();

        // 각 노드별 거리 출력
        for (int i = 1; i <= n; i++) {
            System.out.print(distance(i) + " ");
        }
    }
}
