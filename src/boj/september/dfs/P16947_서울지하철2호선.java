package boj.september.dfs;

import java.util.*;

public class P16947_서울지하철2호선 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited, isCycle;
    static boolean found;
    static int startNode, n;
    static int[] dist;

    static boolean dfs(int cur, int prev){
        visited[cur] = true;
        for(int next : graph[cur]){
            if(!visited[next]){
                if(dfs(next, cur)){
                    if(!found) isCycle[cur] = true;
                    if(cur == startNode) found = true;
                    return true;
                }
            }else if(prev != next){
                isCycle[cur] = true;
                startNode = next;
                return true;
            }
        }
        return false;
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            if(isCycle[i]){
                dist[i] = 0;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : graph[cur]){
                if(dist[next] == -1){
                    dist[next] = dist[cur]+1;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new ArrayList[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, -1);
        for(int i = 0; i<=n; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }
        visited = new boolean[n+1];
        isCycle = new boolean[n+1];

        dfs(1, -1);
        bfs();

        for(int i = 1; i<=n; i++){
            System.out.print(dist[i]+" ");
        }
    }
}
