package boj.hyndaeatuo.graph;

import java.util.*;

public class P16947Blog{
    static int n;
    static boolean[] isCycle;
    static ArrayList<Integer>[] graph;

    static boolean checkCycle(int prev, int node, int start){
        isCycle[node] = true;

        for(int i = 0; i< graph[node].size(); i++){
            int next = graph[node].get(i);

            if(!isCycle[next]) {
                if (checkCycle(node, next, start)) return true;
            }else if(next != prev && next == start) return true;
        }
        isCycle[node] = false;
        return false;
    }

    public static class Node{
        int v;
        int count;

        public Node(int v, int count){
            this.v = v;
            this.count = count;
        }
    }

    static int bfs(int node){
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(new Node(node, 0));
        visited[node] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(isCycle[cur.v]) return cur.count;

            for(int i = 0; i< graph[cur.v].size(); i++){
                int next = graph[cur.v].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new Node(next, cur.count+1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        graph = new ArrayList[n+1];

        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        //Cycle 찾아 표시
        isCycle = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            if(checkCycle(i,i,i)) break;
            isCycle = new boolean[n+1];
        }
        int[] result = new int[n+1];
        for(int i = 1; i<=n; i++){
            if(!isCycle[i]) result[i] = bfs(i);
        }
        for(int i = 1; i<=n; i++){
            System.out.print(result[i]+" ");
        }
    }
}
