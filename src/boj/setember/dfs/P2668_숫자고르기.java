package boj.setember.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class P2668_숫자고르기 {
    static int[] to;
    static boolean[] inCycle, visited, finished;

    static void dfs(int u){
        visited[u] = true;
        int v = to[u];

        if(!visited[v]) dfs(v);
        else if(!finished[v]){ //끝나지 않았다면 순환
            int x = v;
            do{
                inCycle[x] = true;
                x = to[x];
            }while(x != v);
        }

        finished[u] = true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        to = new int[n+1];
        visited = new boolean[n+1];
        finished = new boolean[n+1];
        inCycle = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            to[i] = sc.nextInt();
        }
        sc.close();

        for(int i = 1; i<=n; i++){
            if(!visited[i]) dfs(i);
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 1; i<=n; i++){
            if(inCycle[i]) ans.add(i);
        }
        System.out.println(ans.size());
        for(int x: ans) System.out.println(x);

    }
}
