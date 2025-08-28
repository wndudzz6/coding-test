package boj.september.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//2호선 문제와 같은 방식으로 해결하려 했으나 조금 다름
//2호선 : 양방향 / 사이클 1개
//숫자 고르기 : 단방향 / 사이클 여러 개 + 자기자신 + 서로 참조
//클래식한 풀이 DFS
public class P2668_숫자고르기 {
    static int[] to;
    static int n;
    static boolean[] visited, finished, inCycle;

    static void dfs(int u){
        visited[u] = true;
        int v = to[u];

        if(!visited[v]){
            dfs(v);
        }else if(!finished[v]){
            int x = v;
            do{
                inCycle[x] = true;
                x = to[x];
            }while(v!=x);
        }
        finished[u] = true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        to = new int[n+1];
        for(int i = 1; i<=n; i++) {
            to[i] = sc.nextInt();
        }
        sc.close();
        visited = new boolean[n+1];
        finished = new boolean[n+1];
        inCycle = new boolean[n+1];

        for(int i = 1; i<=n; i++){
            if(!visited[i]) dfs(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            if(inCycle[i]) ans.add(i);
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for(int x : ans) System.out.println(x);
    }
}
