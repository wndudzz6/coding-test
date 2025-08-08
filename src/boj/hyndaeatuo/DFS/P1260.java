package boj.hyndaeatuo.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1260 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dfs, bfs, chd, chb;


    static void DFS(int v, int l){
        if(l==n+1){
            return;
        }else{
            for(int x : graph.get(v)){
                if(chd[x] == 0){
                    chd[x] = 1;
                    dfs[l] = x;
                    DFS(x, l+1);
                }
            }
        }
    }

    static void BFS(int v){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        bfs[1] = v;
        chb[v] = 1;

        int idx = 2;
        while(!Q.isEmpty()){
            int x = Q.poll();
            bfs[idx++] = x;
            for(int next : graph.get(x)){
                if(chb[next] == 0){
                    chb[next] = 1;
                    Q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //정점의 개수
        m = sc.nextInt(); //간선의 개수
        int v = sc.nextInt();//탐색 시작 정점의 번호 v
        graph = new ArrayList<>();
        for(int i = 0; i<=n; i++) graph.add(new ArrayList<>());
        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs = new int[n+1];
        bfs = new int[n+1];
        DFS(v,0);
        BFS(v);
        for(int i = 1; i<=n; i++){
            System.out.print(dfs[i]+" ");
        }
        for(int i = 1; i<=n; i++){
            System.out.print(bfs[i]+" ");
        }
    }

}
